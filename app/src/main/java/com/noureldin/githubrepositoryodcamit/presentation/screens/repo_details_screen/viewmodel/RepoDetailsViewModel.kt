package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noureldin.githubrepositoryodcamit.domain.model.CustomRemoteExceptionDomainModel
import com.noureldin.githubrepositoryodcamit.domain.usecase.FetchRepositoryDetailsUseCase
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toCustomExceptionRemoteUiModel
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toRepoDetailsUiModel
import com.noureldin.githubrepositoryodcamit.presentation.model.CustomRemoteExceptionUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.model.NetworkObserverDetails
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.model.RepoDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val fetchRepositoryDetailsUseCase: FetchRepositoryDetailsUseCase,
    private val networkObserver: NetworkObserverDetails
) : ViewModel() {

    private val _reportDetailsStateFlow = MutableStateFlow<RepoDetailsUiState>(RepoDetailsUiState.InitialState)
    val repoDetailsStateFlow: StateFlow<RepoDetailsUiState> = _reportDetailsStateFlow.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
        handleError(throwable) // Pass throwable instead of Exception
    }

    init {
        networkObserver.registerNetworkCallback()
        observeNetworkConnectivity()
    }

    private fun observeNetworkConnectivity() {
        viewModelScope.launch {
            networkObserver.isConnected.collect { isConnected ->
                if (!isConnected) {
                    _reportDetailsStateFlow.value = RepoDetailsUiState.Error(
                        CustomRemoteExceptionUiModel.NoInternetConnection
                    )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        networkObserver.unregisterNetworkCallback() // Unregister when ViewModel is cleared
    }

    // Function to request repo details
    fun requestRepoDetails(ownerName: String, name: String) {
        _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = true)
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            try {
                val reportDetails = fetchRepositoryDetailsUseCase(ownerName, name)
                _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
                _reportDetailsStateFlow.value = RepoDetailsUiState.RepoDetailsUiModelData(reportDetails.toRepoDetailsUiModel())
            } catch (e: Exception) {
                handleError(e) // Catching general exceptions
            }
        }
    }

    // New function to refresh repo details
    fun refreshRepoDetails(ownerName: String, name: String) {
        requestRepoDetails(ownerName, name) // Call the existing request function
    }

    // Function to handle errors in a centralized manner
    private fun handleError(throwable: Throwable) { // Change parameter type to Throwable
        _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)

        // Check if the throwable is of the expected type
        when (throwable) {
            is CustomRemoteExceptionDomainModel -> {
                _reportDetailsStateFlow.value = RepoDetailsUiState.Error(
                    throwable.toCustomExceptionRemoteUiModel()
                )
            }
            is UnknownHostException -> {
                // Handle the specific case for UnknownHostException
                _reportDetailsStateFlow.value = RepoDetailsUiState.Error(
                    CustomRemoteExceptionUiModel.NoInternetConnection // or another suitable model
                )
            }
            else -> {
                // Handle any other exceptions generically
                _reportDetailsStateFlow.value = RepoDetailsUiState.Error(
                    CustomRemoteExceptionUiModel.Unknown // or a suitable default error model
                )
            }
        }
    }
}





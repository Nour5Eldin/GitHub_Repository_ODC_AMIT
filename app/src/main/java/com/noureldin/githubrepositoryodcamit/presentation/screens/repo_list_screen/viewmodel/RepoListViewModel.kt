package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.viewmodel


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noureldin.githubrepositoryodcamit.domain.model.CustomRemoteExceptionDomainModel
import com.noureldin.githubrepositoryodcamit.domain.usecase.FetchGithubReposListUseCase
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toCustomExceptionRemoteUiModel
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toGithubReposUiModel
import com.noureldin.githubrepositoryodcamit.presentation.model.CustomRemoteExceptionUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.model.NetworkObserver
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.model.RepoListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject
@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val githubReposListUserCase: FetchGithubReposListUseCase,
    application: Application
): ViewModel() {
    private val _repoListStateFlow = MutableStateFlow<RepoListUiState>(RepoListUiState(isLoading = true))
    val repoListStateFlow: StateFlow<RepoListUiState> = _repoListStateFlow.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _repoListStateFlow.value = when (throwable) {
            is CustomRemoteExceptionDomainModel -> {
                RepoListUiState(
                    isLoading = false,
                    isError = true,
                    customRemoteExceptionUiModel = throwable.toCustomExceptionRemoteUiModel()
                )
            }
            is UnknownHostException -> {
                // Only set error state if we were trying to fetch data
                if (_repoListStateFlow.value.isLoading) {
                    RepoListUiState(
                        isLoading = false,
                        isError = true,
                        customRemoteExceptionUiModel = CustomRemoteExceptionUiModel.NoInternetConnection
                    )
                } else {
                    _repoListStateFlow.value // Keep the existing state
                }
            }
            else -> {
                RepoListUiState(
                    isLoading = false,
                    isError = true,
                    customRemoteExceptionUiModel = CustomRemoteExceptionUiModel.Unknown
                )
            }
        }
    }

    private val networkObserver = NetworkObserver(application)

    init {
        viewModelScope.launch {
            networkObserver.isNetworkAvailable.collectLatest { isAvailable ->
                if (!isAvailable && _repoListStateFlow.value.isLoading) {
                    _repoListStateFlow.value = RepoListUiState(
                        isLoading = false,
                        isError = true,
                        customRemoteExceptionUiModel = CustomRemoteExceptionUiModel.NoInternetConnection
                    )
                }
            }
        }
    }

    fun requestGithubRepoList(){
        _repoListStateFlow.value = RepoListUiState(isLoading = true) // Reset to loading state
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            try {
                val repoList = githubReposListUserCase()
                _repoListStateFlow.value = RepoListUiState(
                    isLoading = false,
                    repoList = repoList.map { it.toGithubReposUiModel() }
                )
            } catch (e: Exception) {
                // Handle exceptions as before
                _repoListStateFlow.value = RepoListUiState(
                    isLoading = false,
                    isError = true,
                    customRemoteExceptionUiModel = (e as? CustomRemoteExceptionDomainModel)?.toCustomExceptionRemoteUiModel()
                        ?: CustomRemoteExceptionUiModel.Unknown
                )
            }
        }
    }
}

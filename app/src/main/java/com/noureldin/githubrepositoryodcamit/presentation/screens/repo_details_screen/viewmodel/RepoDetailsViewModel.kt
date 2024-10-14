package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noureldin.githubrepositoryodcamit.domain.model.CustomRemoteExceptionDomainModel
import com.noureldin.githubrepositoryodcamit.domain.usecase.FetchRepositoryDetailsUseCase
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toCustomExceptionRemoteUiModel
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toRepoDetailsUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.model.RepoDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RepoDetailsViewModel(
    private val fetchRepositoryDetailsUseCase: FetchRepositoryDetailsUseCase
): ViewModel() {
    private val _reportDetailsStateFlow = MutableStateFlow<RepoDetailsUiState>(RepoDetailsUiState.InitialState)
    val repoDetailsStateFlow: StateFlow<RepoDetailsUiState> =_reportDetailsStateFlow.asStateFlow()

    private val coroutineExceptionHandler = CoroutineExceptionHandler{_,throwable ->
        _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
      _reportDetailsStateFlow.value = RepoDetailsUiState.Error(
          (throwable as CustomRemoteExceptionDomainModel).toCustomExceptionRemoteUiModel()
      )

    }

    fun requestRepoDetails(
        ownerName: String, name: String
    ){
        _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = true)
        viewModelScope.launch((Dispatchers.IO + coroutineExceptionHandler)) {
            try {
                val reportDetails = fetchRepositoryDetailsUseCase(ownerName, name)
                _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
                _reportDetailsStateFlow.value = RepoDetailsUiState.RepoDetailsUiModelData(reportDetails.toRepoDetailsUiModel())

            }catch (e: Exception){
                _reportDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
                _reportDetailsStateFlow.value = RepoDetailsUiState.Error(
                    (e as CustomRemoteExceptionDomainModel).toCustomExceptionRemoteUiModel()
                )
            }

        }
    }
}

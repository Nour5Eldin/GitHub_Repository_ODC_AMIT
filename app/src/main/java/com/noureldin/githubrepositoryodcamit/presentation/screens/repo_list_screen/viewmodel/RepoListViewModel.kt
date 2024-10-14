package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noureldin.githubrepositoryodcamit.domain.model.CustomRemoteExceptionDomainModel
import com.noureldin.githubrepositoryodcamit.domain.usecase.FetchGithubReposListUseCase
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toCustomExceptionRemoteUiModel
import com.noureldin.githubrepositoryodcamit.presentation.mapper.toGithubReposUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.model.RepoListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val githubReposListUserCase: FetchGithubReposListUseCase
): ViewModel() {
    private val _repoListStateFlow = MutableStateFlow<RepoListUiState>(RepoListUiState(isLoading = true))
           val repoListStateFlow: StateFlow<RepoListUiState> = _repoListStateFlow.asStateFlow()
    private val coroutineExceptionHandler= CoroutineExceptionHandler { _, throwable ->
        _repoListStateFlow.value= RepoListUiState(
            isLoading = false,
            isError = true,
            customRemoteExceptionUiModel = (throwable as CustomRemoteExceptionDomainModel).toCustomExceptionRemoteUiModel()
        )
    }

    fun requestGithubRepoList(){
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            try {
                val repoList = githubReposListUserCase()
                _repoListStateFlow.value = RepoListUiState(
                    isLoading = false,
                    repoList = repoList.map { it.toGithubReposUiModel() }
                )
            } catch (e: Exception){
                _repoListStateFlow.value = RepoListUiState(
                    isLoading = false,
                    isError = true,
                    customRemoteExceptionUiModel = (e as CustomRemoteExceptionDomainModel).toCustomExceptionRemoteUiModel()
                )
            }
        }
    }
}
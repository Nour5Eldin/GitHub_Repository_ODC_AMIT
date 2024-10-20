package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.noureldin.githubrepositoryodcamit.R
import com.noureldin.githubrepositoryodcamit.presentation.common_component.AppBar
import com.noureldin.githubrepositoryodcamit.presentation.common_component.ErrorSection
import com.noureldin.githubrepositoryodcamit.presentation.common_component.shimmer.details.AnimateShimmerDetails
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.component.DetailsItem
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.model.RepoDetailsUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.model.RepoDetailsUiState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.preview_data.fakeRepoDetailsUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.viewmodel.RepoDetailsViewModel
import com.noureldin.githubrepositoryodcamit.presentation.theme.GitHubRepositoryODCAMITTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoDetailsScreen(
    owner: String,
    name: String,
    onClickBack: () -> Unit,
    onShowIssuesClicked: () -> Unit,
    viewModel: RepoDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.requestRepoDetails(ownerName = owner, name = name)
    }

    val repoDetailsUiState by viewModel.repoDetailsStateFlow.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            AppBar(
                onBackButtonClicked = onClickBack,
                title = R.string.details_app_bar_title
            )
        }
    ) { innerPadding ->

        when (repoDetailsUiState) {
            is RepoDetailsUiState.InitialState -> {
                // Optionally handle the initial state
            }
            is RepoDetailsUiState.Loading -> {
                if ((repoDetailsUiState as RepoDetailsUiState.Loading).isLoading) {
                    AnimateShimmerDetails(innerPadding = innerPadding)
                }
            }
            is RepoDetailsUiState.RepoDetailsUiModelData -> {
                DetailsContent(
                    innerPadding = innerPadding,
                    repoDetailsUiModel = (repoDetailsUiState as RepoDetailsUiState.RepoDetailsUiModelData).repositoryDetails,
                    onShowIssuesClicked = onShowIssuesClicked
                )
            }
            is RepoDetailsUiState.Error -> {
                ErrorSection(
                    innerPadding = innerPadding,
                    customErrorExceptionUiModel = (repoDetailsUiState as RepoDetailsUiState.Error).customErrorExceptionUiModel,
                    onRefreshButtonClicked = {
                        viewModel.requestRepoDetails(ownerName = owner, name = name)
                    }
                )
            }
        }
    }
}

@Composable
fun DetailsContent(
    innerPadding: PaddingValues,
    repoDetailsUiModel: RepoDetailsUiModel,
    onShowIssuesClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = repoDetailsUiModel.avatar)
                    .apply(block = {
                        crossfade(1000)
                        placeholder(R.drawable.ic_github_placeholser)
                    })
                    .build()
            ),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(150.dp))
                .padding(top = 16.dp)
        )

        Text(
            text = repoDetailsUiModel.name,
            style = MaterialTheme.typography.headlineSmall,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DetailsItem(
                value = repoDetailsUiModel.stars,
                image = R.drawable.ic_star,
                modifier = Modifier.weight(1f),
                colorFilter = ColorFilter.tint(Color.Yellow),
            )
            Row {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.Blue)
                )
                Text(
                    text = repoDetailsUiModel.language,
                    modifier = Modifier.padding(start = 8.dp),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            DetailsItem(
                value = repoDetailsUiModel.forks,
                image = R.drawable.ic_fork,
                modifier = Modifier.weight(1f),
            )
        }
        Text(
            text = repoDetailsUiModel.description,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onShowIssuesClicked,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = stringResource(R.string.show_issues),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    GitHubRepositoryODCAMITTheme {
        DetailsContent(
            innerPadding = PaddingValues(12.dp),
            repoDetailsUiModel = fakeRepoDetailsUiModel,
            onShowIssuesClicked = {},
        )
    }
}


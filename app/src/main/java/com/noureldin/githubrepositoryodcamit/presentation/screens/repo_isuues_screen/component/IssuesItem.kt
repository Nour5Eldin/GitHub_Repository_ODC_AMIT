package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noureldin.githubrepositoryodcamit.R
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.model.IssuesUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.preview_data.issuesUiModelPreviewData
import com.noureldin.githubrepositoryodcamit.presentation.theme.GitHubRepositoryODCAMITTheme

@Composable
fun IssueItem(
    issuesUiModel: IssuesUiModel,
) {
    val createdAtAnnotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(stringResource(R.string.issue_created_at))
        }
        append(issuesUiModel.date.substringAfter(stringResource(R.string.column)))
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 2.dp)
        .padding(bottom = 4.dp)
        .background(color = MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(12.dp))


    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_issues),
            contentDescription = "issue icom",
            modifier = Modifier
                .size(40.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(RoundedCornerShape(80.dp)),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.inversePrimary)
        )

        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = issuesUiModel.title,
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                        .weight(4f),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = issuesUiModel.state.name,
                    modifier = Modifier
                        .padding(end = 5.dp),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = issuesUiModel.author,
                modifier = Modifier
                    .padding(bottom = 10.dp),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = createdAtAnnotatedString,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
private fun PreviewIssuesItem() {
    GitHubRepositoryODCAMITTheme {
        IssueItem(
            issuesUiModel = issuesUiModelPreviewData.first()
        )
    }
}

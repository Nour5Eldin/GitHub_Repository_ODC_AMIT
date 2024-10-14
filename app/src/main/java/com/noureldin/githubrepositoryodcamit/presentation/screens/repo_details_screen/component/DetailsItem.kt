package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noureldin.githubrepositoryodcamit.R
import com.noureldin.githubrepositoryodcamit.presentation.theme.GitHubRepositoryODCAMITTheme


@Composable
fun DetailsItem(
    value: String,
    image: Int,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    Row(
        modifier = modifier.size(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = image),
            contentDescription = null,
            colorFilter = colorFilter
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = value)
    }
}

@Preview
@Composable
private fun PreviewDetailsItem() {
    GitHubRepositoryODCAMITTheme  {
        DetailsItem(
            value = "200",
            image = R.drawable.ic_star
        )
    }
}
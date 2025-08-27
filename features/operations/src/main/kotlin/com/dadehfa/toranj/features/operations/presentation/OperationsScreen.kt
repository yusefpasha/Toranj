package com.dadehfa.toranj.features.operations.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dadehfa.toranj.common.ui.theme.ToranjTheme
import com.dadehfa.toranj.features.operations.domain.model.MenuItem
import com.dadehfa.toranj.features.operations.domain.model.RepositoryItem
import com.dadehfa.toranj.common.ui.R as CommonUiRes

@Composable
fun OperationsScreen(
    modifier: Modifier = Modifier,
    state: OperationsState,
    onEvent: (event: OperationsEvent) -> Unit
) {
    Scaffold(
        modifier = modifier,
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

@Preview
@Composable
private fun OperationsScreenPreview() {
    ToranjTheme {
        OperationsScreen(
            modifier = Modifier.fillMaxSize(),
            state = OperationsState(
                menuItems = listOf(
                    MenuItem(
                        id = 1,
                        title = "Menu 1",
                        resourceIcon = CommonUiRes.drawable.app_icon
                    ),
                    MenuItem(
                        id = 2,
                        title = "Menu 2",
                        resourceIcon = CommonUiRes.drawable.app_icon
                    ),
                ),
                repository = listOf(
                    RepositoryItem(id = 1, title = "Repo 1", location = "Central Park"),
                    RepositoryItem(id = 2, title = "Repo 2", location = "Somewhere Else"),
                )
            ),
            onEvent = {}
        )
    }
}

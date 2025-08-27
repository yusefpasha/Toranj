package com.dadehfa.toranj.features.operations.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dadehfa.toranj.common.ui.theme.ToranjTheme
import com.dadehfa.toranj.common.ui.theme.padding
import com.dadehfa.toranj.features.operations.R
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
        topBar = {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    space = MaterialTheme.padding.small,
                    alignment = Alignment.Start
                )
            ) {
                stickyHeader {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            modifier = Modifier.padding(MaterialTheme.padding.small),
                            text = stringResource(R.string.operations_repositories),
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }
                items(
                    items = state.repositoryItems,
                    key = { it -> it.id }
                ) { item ->
                    FilterChip(
                        selected = state.selectedRepository == item,
                        onClick = {
                            onEvent(OperationsEvent.OnSelectedRepository(item))
                        },
                        label = {
                            Text(text = item.title)
                        },
                        shape = MaterialTheme.shapes.medium,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedLabelColor = MaterialTheme.colorScheme.onSecondary,
                            selectedContainerColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.primaryContainer,
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                modifier = Modifier.padding(MaterialTheme.padding.medium),
                verticalItemSpacing = MaterialTheme.padding.medium,
                horizontalArrangement = Arrangement.spacedBy(
                    space = MaterialTheme.padding.medium,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                items(
                    items = state.menuItems,
                    key = { it -> it.id }
                ) { item ->
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.size(48.dp),
                            painter = painterResource(item.resourceIcon),
                            contentDescription = null
                        )
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
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
                        resourceIcon = CommonUiRes.drawable.register_order
                    ),
                    MenuItem(
                        id = 2,
                        title = "Menu 2",
                        resourceIcon = CommonUiRes.drawable.inventory_adjust
                    ),
                    MenuItem(
                        id = 3,
                        title = "Menu 3",
                        resourceIcon = CommonUiRes.drawable.managing_products
                    ),
                    MenuItem(
                        id = 4,
                        title = "Menu 4",
                        resourceIcon = CommonUiRes.drawable.rials_report
                    ),
                    MenuItem(
                        id = 5,
                        title = "Menu 5",
                        resourceIcon = CommonUiRes.drawable.sale_report
                    ),
                    MenuItem(
                        id = 6,
                        title = "Menu 6",
                        resourceIcon = CommonUiRes.drawable.send_order
                    ),
                    MenuItem(
                        id = 7,
                        title = "Menu 7",
                        resourceIcon = CommonUiRes.drawable.cartoon_move
                    ),
                    MenuItem(
                        id = 8,
                        title = "Menu 8",
                        resourceIcon = CommonUiRes.drawable.invoice_totally_folder
                    ),
                ),
                repositoryItems = listOf(
                    RepositoryItem(id = 1, title = "Repo 1", location = "Somewhere Else"),
                    RepositoryItem(id = 2, title = "Repo 2", location = "Somewhere Else"),
                    RepositoryItem(id = 3, title = "Repo 3", location = "Somewhere Else"),
                    RepositoryItem(id = 4, title = "Repo 4", location = "Somewhere Else"),
                    RepositoryItem(id = 5, title = "Repo 5", location = "Somewhere Else"),
                    RepositoryItem(id = 6, title = "Repo 6", location = "Somewhere Else"),
                )
            ),
            onEvent = {}
        )
    }
}

package com.dadehfa.toranj.features.operations.presentation

import androidx.lifecycle.ViewModel
import com.dadehfa.toranj.features.operations.domain.model.MenuItem
import com.dadehfa.toranj.features.operations.domain.model.RepositoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.dadehfa.toranj.common.ui.R as CommonUiRes


class OperationViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        OperationsState(
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
        )
    )
    val state = _state.asStateFlow()

    fun onEvent(event: OperationsEvent) {
        when (event) {
            is OperationsEvent.OnSelectedRepository -> {
                _state.update { value ->
                    value.copy(
                        selectedRepository = event.repository
                    )
                }
            }

            else -> Unit
        }
    }

}

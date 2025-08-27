package com.dadehfa.toranj.features.operations.presentation

import androidx.compose.runtime.Stable
import com.dadehfa.toranj.features.operations.domain.model.MenuItem
import com.dadehfa.toranj.features.operations.domain.model.RepositoryItem

@Stable
data class OperationsState(
    val menuItems: List<MenuItem> = emptyList(),
    val repositoryItems: List<RepositoryItem> = emptyList(),
    val selectedRepository: RepositoryItem? = repositoryItems.firstOrNull()
)

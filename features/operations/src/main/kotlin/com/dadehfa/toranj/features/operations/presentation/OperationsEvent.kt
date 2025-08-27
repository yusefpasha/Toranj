package com.dadehfa.toranj.features.operations.presentation

import androidx.compose.runtime.Immutable
import com.dadehfa.toranj.features.operations.domain.model.MenuItem
import com.dadehfa.toranj.features.operations.domain.model.RepositoryItem

@Immutable
sealed class OperationsEvent {
    data class OnSelectedMenu(val menu: MenuItem) : OperationsEvent()
    data class OnSelectedRepository(val repository: RepositoryItem) : OperationsEvent()
}
package com.dadehfa.toranj.features.operations.presentation

import androidx.compose.runtime.Immutable
import com.dadehfa.toranj.features.operations.domain.utils.MenuId
import com.dadehfa.toranj.features.operations.domain.utils.RepositoryId

@Immutable
sealed class OperationsEvent {
    data class OnSelectedMenu(val menuId: MenuId) : OperationsEvent()
    data class OnSelectedRepository(val repositoryId: RepositoryId) : OperationsEvent()
}
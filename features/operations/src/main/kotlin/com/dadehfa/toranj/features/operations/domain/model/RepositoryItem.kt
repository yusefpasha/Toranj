package com.dadehfa.toranj.features.operations.domain.model

import com.dadehfa.toranj.features.operations.domain.utils.RepositoryId

data class RepositoryItem(
    val id: RepositoryId,
    val title: String,
    val location: String,
)

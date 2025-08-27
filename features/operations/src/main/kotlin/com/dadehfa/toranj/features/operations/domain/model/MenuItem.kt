package com.dadehfa.toranj.features.operations.domain.model

import androidx.annotation.DrawableRes
import com.dadehfa.toranj.features.operations.domain.utils.MenuId

data class MenuItem(
    val id: MenuId,
    val title: String,
    @DrawableRes val resourceIcon: Int
)

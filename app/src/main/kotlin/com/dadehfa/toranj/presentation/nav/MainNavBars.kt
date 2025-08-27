package com.dadehfa.toranj.presentation.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainNavBars(
    val title: String = "",
    val icon: ImageVector = Icons.Rounded.Warning
) {
    Operations(
        title = "Operations",
        icon = Icons.Rounded.Menu
    ),
    Dashboard(
        title = "Dashboard",
        icon = Icons.Rounded.Home
    ),
    Setting(
        title = "Setting",
        icon = Icons.Rounded.Settings
    )
}
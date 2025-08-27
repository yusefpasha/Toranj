package com.dadehfa.toranj.features.register.presentation

import androidx.compose.runtime.Stable

@Stable
data class LoginState(
    val error: String? = null,
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isRememberMe: Boolean = false,
    val isUsernameValid: Boolean = true,
    val isPasswordValid: Boolean = true,
)

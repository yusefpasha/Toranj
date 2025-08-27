package com.dadehfa.toranj.features.register.presentation

import androidx.compose.runtime.Immutable

@Immutable
sealed class RegisterEvent {
    data class OnUsernameChange(val username: String) : RegisterEvent()
    data class OnPasswordChange(val password: String) : RegisterEvent()
    data class OnRememberMeChange(val isRememberMe: Boolean) : RegisterEvent()
    object OnLoginClick : RegisterEvent()
}
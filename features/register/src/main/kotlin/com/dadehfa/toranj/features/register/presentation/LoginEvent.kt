package com.dadehfa.toranj.features.register.presentation

import androidx.compose.runtime.Immutable

@Immutable
sealed class LoginEvent {
    data class OnUsernameChange(val username: String) : LoginEvent()
    data class OnPasswordChange(val password: String) : LoginEvent()
    data class OnRememberMeChange(val isRememberMe: Boolean) : LoginEvent()
    object OnLoginClick : LoginEvent()
    object OnDismissErrorClick : LoginEvent()
}
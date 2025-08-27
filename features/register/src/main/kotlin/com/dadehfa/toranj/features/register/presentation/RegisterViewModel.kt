package com.dadehfa.toranj.features.register.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {

    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.OnUsernameChange -> {
                _state.update { value ->
                    value.copy(username = event.username)
                }
            }

            is RegisterEvent.OnPasswordChange -> {
                _state.update { value ->
                    value.copy(password = event.password)
                }
            }

            is RegisterEvent.OnRememberMeChange -> {
                _state.update { value ->
                    value.copy(isRememberMe = event.isRememberMe)
                }
            }

            else -> {}
        }
    }

}
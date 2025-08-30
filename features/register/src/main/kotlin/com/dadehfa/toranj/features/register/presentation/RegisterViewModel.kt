package com.dadehfa.toranj.features.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dadehfa.toranj.common.utils.coroutineContextIO
import com.dadehfa.toranj.features.register.domain.model.LoginRequest
import com.dadehfa.toranj.features.register.domain.use_case.LoginUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegisterViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _state = MutableStateFlow<RegisterContract.State>(RegisterContract.State.Idle)
    val state: StateFlow<RegisterContract.State> = _state.asStateFlow()

    private val _effect = Channel<RegisterContract.Effect>()
    val effect: Flow<RegisterContract.Effect> = _effect.receiveAsFlow()

    fun setIntent(intent: RegisterContract.Intent) {
        when (intent) {
            is RegisterContract.Intent.Login -> login(intent.username, intent.password)
        }
    }

    private fun login(username: String, password: String) {
        viewModelScope.launch(coroutineContextIO) {
            _state.value = RegisterContract.State.Loading
            val data = LoginRequest(username, password)
            loginUseCase(data)
                .onSuccess { response ->
                    _state.value =
                        RegisterContract.State.Success(response.firstName, response.lastName)
                    _effect.send(RegisterContract.Effect.ShowToast("Login Successful!"))
                }
                .onFailure { error ->
                    _state.value = RegisterContract.State.Failure(error.message ?: "Unknown error")
                }
        }
    }

}
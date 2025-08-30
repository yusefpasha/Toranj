package com.dadehfa.toranj.features.register.presentation

object RegisterContract {

    sealed interface State {
        data object Idle : State
        data object Loading : State
        data class Failure(val message: String) : State
        data class Success(val firstName: String, val lastName: String) : State
    }

    sealed interface Intent {
        data class Login(val username: String, val password: String) : Intent
    }

    sealed interface Effect {
        data object Idle : Effect
        data class ShowToast(val message: String) : Effect
        data object NavigateToHome : Effect
    }
}
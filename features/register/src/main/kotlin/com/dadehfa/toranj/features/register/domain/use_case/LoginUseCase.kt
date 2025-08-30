package com.dadehfa.toranj.features.register.domain.use_case

import com.dadehfa.toranj.features.register.domain.model.LoginRequest
import com.dadehfa.toranj.features.register.domain.model.LoginResponse
import com.dadehfa.toranj.features.register.domain.repository.RegisterRepository

class LoginUseCase(private val registerRepository: RegisterRepository) {
    suspend operator fun invoke(data: LoginRequest): Result<LoginResponse> {
        if (data.username.isBlank() || data.password.isBlank()) {
            return Result.failure(IllegalArgumentException("Username and password cannot be empty."))
        }
        return registerRepository.login(data)
    }
}

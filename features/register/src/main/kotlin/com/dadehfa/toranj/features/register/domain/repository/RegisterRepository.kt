package com.dadehfa.toranj.features.register.domain.repository

import com.dadehfa.toranj.features.register.domain.model.LoginRequest
import com.dadehfa.toranj.features.register.domain.model.LoginResponse

interface RegisterRepository {
    suspend fun login(body: LoginRequest): Result<LoginResponse>
}

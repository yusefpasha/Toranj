package com.dadehfa.toranj.features.register.data.repository

import com.dadehfa.toranj.features.register.data.mapper.toDataType
import com.dadehfa.toranj.features.register.data.mapper.toDomainType
import com.dadehfa.toranj.features.register.data.remote.AuthRemoteDataSource
import com.dadehfa.toranj.features.register.domain.model.LoginRequest
import com.dadehfa.toranj.features.register.domain.model.LoginResponse
import com.dadehfa.toranj.features.register.domain.repository.RegisterRepository

class RegisterRepositoryImpl(
    private val remoteDataSource: AuthRemoteDataSource
) : RegisterRepository {
    override suspend fun login(body: LoginRequest): Result<LoginResponse> {
        return runCatching {
            val response = remoteDataSource.login(body.toDataType())
            response.toDomainType()
        }
    }
}
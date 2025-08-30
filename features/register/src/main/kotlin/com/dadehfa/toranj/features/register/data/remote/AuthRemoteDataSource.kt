package com.dadehfa.toranj.features.register.data.remote

import com.dadehfa.toranj.features.register.data.remote.dto.LoginRequestDto
import com.dadehfa.toranj.features.register.data.remote.dto.LoginResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthRemoteDataSource(private val httpClient: HttpClient) {
    suspend fun login(request: LoginRequestDto): LoginResponseDto {
        return httpClient.post("https://dummyjson.com/auth/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}
package com.dadehfa.toranj.features.register.domain.model

data class LoginResponse(
    val accessToken: AuthToken,
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val refreshToken: AuthToken,
    val username: String
)
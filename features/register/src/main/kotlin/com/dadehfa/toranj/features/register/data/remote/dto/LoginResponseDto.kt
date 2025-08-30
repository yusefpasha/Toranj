package com.dadehfa.toranj.features.register.data.remote.dto

import com.dadehfa.toranj.features.register.domain.model.AuthToken
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val accessToken: @Contextual AuthToken,
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val refreshToken: @Contextual AuthToken,
    val username: String
)
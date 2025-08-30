package com.dadehfa.toranj.features.register.data.mapper

import com.dadehfa.toranj.features.register.data.remote.dto.LoginRequestDto
import com.dadehfa.toranj.features.register.data.remote.dto.LoginResponseDto
import com.dadehfa.toranj.features.register.domain.model.LoginRequest
import com.dadehfa.toranj.features.register.domain.model.LoginResponse

fun LoginRequest.toDataType(): LoginRequestDto {
    return LoginRequestDto(
        username = this.username,
        password = this.password
    )
}

fun LoginResponseDto.toDomainType(): LoginResponse {
    return LoginResponse(
        accessToken = accessToken,
        email = email,
        firstName = firstName,
        gender = gender,
        id = id,
        image = image,
        lastName = lastName,
        refreshToken = refreshToken,
        username = username,
    )
}

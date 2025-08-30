package com.dadehfa.toranj.features.register.domain.model

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class AuthToken(val value: String)

package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: String,
    val username: String
)

@Serializable
data class UserWithTokenResponse(
    val user: UserResponse,
    val token: String
)

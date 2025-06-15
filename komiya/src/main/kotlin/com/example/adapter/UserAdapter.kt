package com.example.adapter

import com.example.dao.UserDAO
import com.example.dto.UserResponse

class UserAdapter(private val userDAO: UserDAO) {

    suspend fun registerUser(username: String, hashedPassword: String): UserResponse {
        val entity = userDAO.insertUser(username, hashedPassword)
        return UserResponse(
            id = entity.id.toHexString(),
            username = entity.username
        )
    }
}

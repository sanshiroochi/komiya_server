package com.example.dao

import com.example.config.MongoClientProvider
import com.example.entity.UserEntity
import org.litote.kmongo.eq
import org.litote.kmongo.coroutine.CoroutineCollection

class UserDAO {
    private val usersCollection: CoroutineCollection<UserEntity> =
        MongoClientProvider.database.getCollection()

    suspend fun findByUsername(username: String): UserEntity? {
        return usersCollection.findOne(UserEntity::username eq username)
    }

    suspend fun insertUser(username: String, hashedPassword: String): UserEntity {
        val newUser = UserEntity(username = username, password = hashedPassword)
        usersCollection.insertOne(newUser)
        return newUser
    }
}

package com.example.entity

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class UserEntity(
    @BsonId
    @Contextual val id: ObjectId = ObjectId(),
    val username: String,
    val password: String
)

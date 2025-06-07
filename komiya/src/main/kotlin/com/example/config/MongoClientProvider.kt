package com.example.config

import com.mongodb.ConnectionString
import io.github.cdimascio.dotenv.dotenv
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo // ← これが必要

object MongoClientProvider {
    private val dotenv = dotenv()

    private val connectionString = dotenv["MONGO_URI"]
        ?: throw IllegalStateException("MONGO_URI is not defined in .env file")

    private val databaseName = dotenv["MONGO_DB"]
        ?: throw IllegalStateException("MONGO_DB is not defined in .env file")

    // ✅ ここが重要
    private val client = KMongo.createClient(connectionString).coroutine

    val database = client.getDatabase(databaseName)
}

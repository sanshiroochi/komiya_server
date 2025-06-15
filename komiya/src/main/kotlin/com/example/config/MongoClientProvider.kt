package com.example.config

import com.mongodb.ConnectionString
import io.github.cdimascio.dotenv.Dotenv
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

object MongoClientProvider {
    private val dotenv: Dotenv = Dotenv.configure()
        .filename(".env.stg")
        .load()

    private val connectionString = dotenv.get("MONGO_URI")
        ?: throw IllegalStateException("MONGO_URI is not defined in .env file")

    private val databaseName = dotenv.get("MONGO_DB")
        ?: throw IllegalStateException("MONGO_DB is not defined in .env file")

    private val client = KMongo.createClient(connectionString).coroutine

    val database = client.getDatabase(databaseName)
}

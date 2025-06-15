// Application.kt
package com.example

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import com.example.handler.authRoutes
import com.example.dao.UserDAO
import com.example.adapter.UserAdapter

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    val userAdapter = UserAdapter(UserDAO()) // 依存注入

    routing {
        authRoutes(userAdapter)
    }
}

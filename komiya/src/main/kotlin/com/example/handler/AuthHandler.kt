package com.example.handler

import com.example.adapter.UserAdapter
import com.example.dto.UserWithTokenResponse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import org.mindrot.jbcrypt.BCrypt
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.*

fun Route.authRoutes(userAdapter: UserAdapter) {

    post("/signup") {
        val request = call.receive<Map<String, String>>()
        val username = request["username"]
        val password = request["password"]

        if (username.isNullOrBlank() || password.isNullOrBlank()) {
            call.respond(HttpStatusCode.BadRequest, "Username and password must not be empty")
            return@post
        }

        val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
        val user = userAdapter.registerUser(username, hashedPassword)

        val token = JWT.create()
            .withAudience("your-audience")
            .withIssuer("your-issuer")
            .withClaim("username", user.username)
            .withExpiresAt(Date(System.currentTimeMillis() + 3_600_000)) // 1 hour
            .sign(Algorithm.HMAC256("your-secret"))

        call.respond(
            HttpStatusCode.OK,
            UserWithTokenResponse(user = user, token = token)
        )
    }
}

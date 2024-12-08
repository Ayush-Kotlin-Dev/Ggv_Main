package com.ayush.ggv

import com.ayush.ggv.dao.DatabaseFactory
import com.ayush.ggv.di.configureDI
import com.ayush.ggv.plugins.configureRouting
import com.ayush.ggv.plugins.configureSecurity
import com.ayush.ggv.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    configureRouting()
    configureSerialization()
    configureDI()
    configureSecurity()
}

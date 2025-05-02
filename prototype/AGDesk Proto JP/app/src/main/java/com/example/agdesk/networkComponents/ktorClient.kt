package com.example.agdesk.networkComponents

import io.ktor.client.*
import io.ktor.client.engine.android.Android
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json



class ktorClient() {


    // Set up Ktor client with JSON serialization
    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

}



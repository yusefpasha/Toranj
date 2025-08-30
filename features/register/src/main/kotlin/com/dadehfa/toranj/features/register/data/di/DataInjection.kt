package com.dadehfa.toranj.features.register.data.di

import com.dadehfa.toranj.features.register.data.remote.AuthRemoteDataSource
import com.dadehfa.toranj.features.register.data.remote.dto.ErrorResponse
import com.dadehfa.toranj.features.register.data.remote.model.InvalidCredentialsException
import com.dadehfa.toranj.features.register.data.repository.RegisterRepositoryImpl
import com.dadehfa.toranj.features.register.domain.repository.RegisterRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val RegisterDataInjection = module {
    single<HttpClient> {
        HttpClient(Android) {

            expectSuccess = false

            install(Logging) {
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }

            HttpResponseValidator {
                validateResponse { response: HttpResponse ->
                    if (!response.status.isSuccess()) {
                        val errorBody: ErrorResponse = response.body()
                        when (response.status) {
                            HttpStatusCode.BadRequest, HttpStatusCode.Unauthorized -> {
                                throw InvalidCredentialsException(errorBody.message)
                            }
                            else -> {
                                throw Exception("Server error: ${response.status.description}")
                            }
                        }
                    }
                }
            }
        }
    }
    singleOf(::AuthRemoteDataSource)
    singleOf(::RegisterRepositoryImpl) { bind<RegisterRepository>() }
}

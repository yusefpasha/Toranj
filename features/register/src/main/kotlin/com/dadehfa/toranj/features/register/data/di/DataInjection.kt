package com.dadehfa.toranj.features.register.data.di

import com.dadehfa.toranj.features.register.data.remote.AuthRemoteDataSource
import com.dadehfa.toranj.features.register.data.repository.RegisterRepositoryImpl
import com.dadehfa.toranj.features.register.domain.repository.RegisterRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val RegisterDataInjection = module {
    single<HttpClient> {
        HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    singleOf(::AuthRemoteDataSource)
    singleOf(::RegisterRepositoryImpl) { bind<RegisterRepository>() }
}

package com.dadehfa.toranj.features.register.domain.di

import com.dadehfa.toranj.features.register.domain.use_case.LoginUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val RegisterDomainInjection = module {
    factoryOf(::LoginUseCase)
}
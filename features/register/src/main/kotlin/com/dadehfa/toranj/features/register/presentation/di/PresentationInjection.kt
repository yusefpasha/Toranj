package com.dadehfa.toranj.features.register.presentation.di

import com.dadehfa.toranj.features.register.presentation.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val RegisterPresentationInjection = module {
    viewModelOf(::RegisterViewModel)
}

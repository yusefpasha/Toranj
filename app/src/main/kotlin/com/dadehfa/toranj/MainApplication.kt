package com.dadehfa.toranj

import android.app.Application
import com.dadehfa.toranj.features.register.data.di.RegisterDataInjection
import com.dadehfa.toranj.features.register.domain.di.RegisterDomainInjection
import com.dadehfa.toranj.features.register.presentation.di.RegisterPresentationInjection
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                RegisterDataInjection,
                RegisterDomainInjection,
                RegisterPresentationInjection
            )
        }
    }

}
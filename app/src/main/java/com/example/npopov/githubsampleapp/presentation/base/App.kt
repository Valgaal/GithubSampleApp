package com.example.npopov.githubsampleapp.presentation.base

import android.app.Application
import com.example.npopov.githubsampleapp.data.repository.GistRepositoryImpl
import com.example.npopov.githubsampleapp.di.DI

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DI.init(applicationContext)
    }

}
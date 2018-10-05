package com.example.npopov.githubsampleapp

import android.app.Application
import com.example.npopov.githubsampleapp.Models.Repository

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Repository.getInstance(this)
    }

}
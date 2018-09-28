package com.example.npopov.githubsampleapp

import android.app.Application
import com.example.npopov.githubsampleapp.Models.Repository

class App : Application() {

    fun getRepository(): Repository {
        return Repository.getInstance(this)
    }
}
package com.example.npopov.githubsampleapp.di

import android.content.Context
import com.example.npopov.githubsampleapp.di.component.ApplicationComponent
import com.example.npopov.githubsampleapp.di.component.DaggerApplicationComponent
import com.example.npopov.githubsampleapp.di.component.GistComponent

object DI {

    lateinit var app: ApplicationComponent

    private var gist: GistComponent? = null

    fun init(context: Context) {
        this.app = DaggerApplicationComponent
                .builder()
                .application(context)
                .build()
    }

    fun getGistComponent(): GistComponent {
        if (gist == null) {
            gist = app.githubComponent().build()
        }
        return gist as GistComponent
    }
}
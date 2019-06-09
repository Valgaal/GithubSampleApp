package com.example.npopov.githubsampleapp.di.component

import android.content.Context
import com.example.npopov.githubsampleapp.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun githubComponent(): GistComponent.Builder
}
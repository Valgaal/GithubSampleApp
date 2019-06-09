package com.example.npopov.githubsampleapp.di.component

import com.example.npopov.githubsampleapp.di.module.GistModule
import com.example.npopov.githubsampleapp.di.scope.GistScope
import com.example.npopov.githubsampleapp.presentation.gistDetails.GistDetailsPresenter
import com.example.npopov.githubsampleapp.presentation.gistList.GistListPresenter
import dagger.Subcomponent

@GistScope
@Subcomponent(modules = [GistModule::class])
interface GistComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): GistComponent
    }

    fun inject(gistDetailsPresenter: GistDetailsPresenter)
    fun inject(gistListPresenter: GistListPresenter)
}
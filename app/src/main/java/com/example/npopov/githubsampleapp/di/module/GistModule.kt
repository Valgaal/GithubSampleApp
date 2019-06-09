package com.example.npopov.githubsampleapp.di.module

import com.example.npopov.githubsampleapp.data.repository.GistRepositoryImpl
import com.example.npopov.githubsampleapp.di.scope.GistScope
import com.example.npopov.githubsampleapp.domain.repository.GistRepository
import dagger.Binds
import dagger.Module

@Module
abstract class GistModule {

    @Binds
    @GistScope
    abstract fun providesGistRepository(gistRepository: GistRepositoryImpl): GistRepository
}
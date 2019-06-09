package com.example.npopov.githubsampleapp.domain.repository

import com.example.npopov.githubsampleapp.domain.models.Commit
import com.example.npopov.githubsampleapp.domain.models.Gist
import com.example.npopov.githubsampleapp.domain.models.GistDetails
import io.reactivex.Single

interface GistRepository {

    fun getAllPublicGists(): Single<List<Gist>>

    fun getSingleGist(id: String): Single<GistDetails>

    fun getGistCommits(id: String): Single<List<Commit>>
}
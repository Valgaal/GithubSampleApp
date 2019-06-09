package com.example.npopov.githubsampleapp.data.repository

import com.example.npopov.githubsampleapp.data.api.GithubApi
import com.example.npopov.githubsampleapp.data.converters.GistsConverter
import com.example.npopov.githubsampleapp.domain.models.Gist
import com.example.npopov.githubsampleapp.domain.models.Commit
import com.example.npopov.githubsampleapp.domain.models.GistDetails
import com.example.npopov.githubsampleapp.domain.repository.GistRepository
import com.google.gson.internal.bind.util.ISO8601Utils
import io.reactivex.Single
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class GistRepositoryImpl @Inject constructor(private val api: GithubApi) : GistRepository {

    override fun getAllPublicGists(): Single<List<Gist>> {
        val date = ISO8601Utils.format(Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7)))
        return api
                .getAllPublicGists(date)
                .map { GistsConverter.convertFromNetwork(it) }
    }

    override fun getSingleGist(id: String): Single<GistDetails> {
        return api
                .getSingleGistDetails(id)
                .map { GistsConverter.convertFromNetworkDetails(it) }
    }

    override fun getGistCommits(id: String): Single<List<Commit>> {
        return api
                .getGistCommits(id)
                .map { GistsConverter.convertCommitFromNetwork(it) }

    }
}
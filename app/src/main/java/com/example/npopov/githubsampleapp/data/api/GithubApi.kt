package com.example.npopov.githubsampleapp.data.api

import com.example.npopov.githubsampleapp.data.models.commit.CommitResponse
import com.example.npopov.githubsampleapp.data.models.gistList.GistResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApi {

    @GET("gists/public")
    fun getAllPublicGists(
            @Query("since") since: String?): Single<List<GistResponse>>

    @GET("gists/{id}")
    fun getSingleGistDetails(
            @Path("id") gistId: String): Single<GistResponse>

    @GET("gists/{id}/commits")
    fun getGistCommits(
            @Path("id") gistId: String): Single<List<CommitResponse>>
}
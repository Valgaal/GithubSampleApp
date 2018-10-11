package com.example.npopov.githubsampleapp

import com.example.npopov.githubsampleapp.Models.UserDetailsResponse
import com.example.npopov.githubsampleapp.Models.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface UsersApi {

    @GET("users")
    fun getUsers(
            @Query("since") since: Int): Observable<List<UserResponse>>

    @GET("users/{user}")
    fun getUserDetails(
            @Path("user") userLogin: String): Observable<UserDetailsResponse>
}
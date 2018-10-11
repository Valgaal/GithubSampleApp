package com.example.npopov.githubsampleapp.Models

import android.content.Context
import com.example.npopov.githubsampleapp.Details.DetailsModel
import com.example.npopov.githubsampleapp.SingletonHolder
import com.example.npopov.githubsampleapp.UsersApi
import io.reactivex.Observable
import io.reactivex.observables.ConnectableObservable
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class Repository private constructor(context: Context){
    private val BASE_SEARCH_URL = "https://api.github.com/"
    private var api: UsersApi;
    private lateinit  var users:List<UserResponse>

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        api = retrofit.create(UsersApi::class.java)

    }

    fun getUsers(since: Int): Observable<List<UserResponse>> {
        val usersList = api.getUsers(since)
        usersList.map { users = it }
        return usersList
    }

    fun getUserDetails(login: String): Observable<UserDetailsResponse> {
        return api.getUserDetails(login)
    }

    companion object : SingletonHolder<Repository, Context>(::Repository)
}
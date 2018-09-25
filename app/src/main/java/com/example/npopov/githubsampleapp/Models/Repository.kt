package com.example.npopov.githubsampleapp.Models

import android.content.Context
import com.example.npopov.githubsampleapp.SingletonHolder
import com.example.npopov.githubsampleapp.UsersApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class Repository private constructor(context: Context){
    private val BASE_SEARCH_URL = "https://api.github.com/users/"
    private var api: UsersApi;

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_SEARCH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
        api = retrofit.create(UsersApi::class.java)

    }

    private fun getUsers(since: Int): Observable<List<UserResponse>> {
        return api.getUsers(since)
    }

    companion object : SingletonHolder<Repository, Context>(::Repository)
}
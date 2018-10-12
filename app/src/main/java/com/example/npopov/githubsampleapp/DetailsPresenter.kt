package com.example.npopov.githubsampleapp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.npopov.githubsampleapp.Models.Repository
import com.example.npopov.githubsampleapp.Models.UserDetailsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class DetailsPresenter(private val login:String,
                       private val repository: Repository): MvpPresenter<DetailsView>() {
    init {
        repository.getUserDetails(login)
                .map { convertToDetailsModel(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {it ->
                            viewState.showDetails(it)
                        },
                        {error ->
                            viewState.showError(error.toString())
                        }
                )
    }

    private fun convertToDetailsModel(userDetailsResponse: UserDetailsResponse): DetailsModel {
        return DetailsModel(
                userDetailsResponse.avatar_url,
                userDetailsResponse.html_url,
                userDetailsResponse.name,
                userDetailsResponse.public_repos)
    }

}
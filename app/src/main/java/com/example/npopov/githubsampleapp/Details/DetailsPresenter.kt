package com.example.npopov.githubsampleapp.Details

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
        viewState.startLoading()
        repository.getUserDetails(login)
                .map { convertToDetailsModel(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {it ->
                            viewState.showDetails(it)
                            viewState.finishLoading()
                        },
                        {error ->
                            viewState.showError(error.toString())
                            viewState.finishLoading()
                        }
                )
    }

    private fun convertToDetailsModel(userDetailsResponse: UserDetailsResponse): DetailsModel{
        return DetailsModel("","","",0)
    }

}
package com.example.npopov.githubsampleapp.Main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.npopov.githubsampleapp.Models.Repository
import com.example.npopov.githubsampleapp.Models.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class ListPresenter(private val repository: Repository): MvpPresenter<ListView>() {

    fun loadUsers(){ //prepare response Model
        viewState.startLoading()
       repository.getUsers(0)
               .flatMapIterable { it -> it }
               .map { convertToListModel(it) }
               .toList()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe({list ->
                   viewState.showUsers(list)
                   viewState.finishLoading()
               },
                          {error -> viewState.showError(error.toString())})

    }

    private fun  convertToListModel(userResponse: UserResponse ): ListModel{
        return ListModel("","")
    }


}
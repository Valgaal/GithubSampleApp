package com.example.npopov.githubsampleapp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.npopov.githubsampleapp.Models.Repository
import com.example.npopov.githubsampleapp.Models.UserResponse
import com.example.npopov.githubsampleapp.UsersList.ListModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class ListPresenter(private val repository: Repository): MvpPresenter<ListView>() {

    init {
        loadUsers()
    }

    fun loadUsers(){
        viewState.startLoading()
        repository.getUsers(0)
               .flatMapIterable { it -> it }
               .map { convertToListModel(it) }
               .toList()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(
                       {list ->
                           viewState.showUsers(list)
                           viewState.finishLoading()
                       },
                       {error ->
                           viewState.showError(error.toString())
                           viewState.finishLoading()
                       }
               )

    }

    private fun  convertToListModel(userResponse: UserResponse ): ListModel {
        return ListModel(userResponse.login, userResponse.avatar_url)
    }

    fun userClicked(listModel: ListModel){
        viewState.showUserDetails(listModel.login)
    }
}
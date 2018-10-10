package com.example.npopov.githubsampleapp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.npopov.githubsampleapp.UsersList.ListModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface ListView : MvpView {

    fun showUsers(users: List<ListModel> )

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String?)

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = "TAG_LOADING")
    fun startLoading()

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = "TAG_LOADING")
    fun finishLoading()

}
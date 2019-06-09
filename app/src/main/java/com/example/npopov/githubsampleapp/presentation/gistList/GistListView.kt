package com.example.npopov.githubsampleapp.presentation.gistList

import com.example.npopov.githubsampleapp.presentation.utils.AddToEndSingleByTagStateStrategy
import com.example.npopov.githubsampleapp.domain.models.Gist
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface GistListView : MvpView {

    fun showGists(gists: List<Gist>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String?)

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = "TAG_LOADING")
    fun startLoading()

    @StateStrategyType(value = AddToEndSingleByTagStateStrategy::class, tag = "TAG_LOADING")
    fun finishLoading()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showUserDetails(id: String)

}
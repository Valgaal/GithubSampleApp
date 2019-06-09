package com.example.npopov.githubsampleapp.presentation.gistDetails

import com.example.npopov.githubsampleapp.domain.models.Commit
import com.example.npopov.githubsampleapp.domain.models.GistDetails
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface GistDetailsView : MvpView {

    fun showDetails(gistDetails: GistDetails, expandedList: MutableList<Boolean>)

    fun showCommitInfo(commits: List<Commit>)

    fun showLoading()

    fun hideLoading()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun changeItemContent(isExpanded: Boolean, pos: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String?)

}
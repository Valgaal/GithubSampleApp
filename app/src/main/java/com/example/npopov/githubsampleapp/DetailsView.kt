package com.example.npopov.githubsampleapp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.npopov.githubsampleapp.DetailsModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView: MvpView{

    fun showDetails(detailsModel: DetailsModel)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String?)

}
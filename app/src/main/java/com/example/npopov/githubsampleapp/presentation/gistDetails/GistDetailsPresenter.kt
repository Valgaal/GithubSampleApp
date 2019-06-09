package com.example.npopov.githubsampleapp.presentation.gistDetails

import com.example.npopov.githubsampleapp.di.DI
import com.example.npopov.githubsampleapp.presentation.base.BasePresenter
import com.example.npopov.githubsampleapp.domain.models.Commit
import com.example.npopov.githubsampleapp.domain.models.GistDetails
import com.example.npopov.githubsampleapp.domain.repository.GistRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class GistDetailsPresenter(id: String) : BasePresenter<GistDetailsView>() {

    @Inject
    lateinit var repository: GistRepository

    private var expandedList: MutableList<Boolean> = ArrayList()

    init {
        DI.getGistComponent().inject(this)

        viewState.showLoading()
        disposable.add(
                repository.getSingleGist(id)
                        .zipWith(repository.getGistCommits(id),
                                BiFunction { first: GistDetails, second: List<Commit> ->
                                    Pair(first, second)
                                })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    for (i in 0..it.first.files.size) {
                                        expandedList.add(false)
                                    }
                                    viewState.showDetails(it.first, expandedList)
                                    viewState.showCommitInfo(it.second)
                                    viewState.hideLoading()
                                },
                                { error ->
                                    viewState.showError(error.toString())
                                    viewState.hideLoading()
                                }
                        )
        )
    }

    fun expandedClicked(position: Int) {
        var isExpanded = expandedList[position]
        isExpanded = !isExpanded
        viewState.changeItemContent(isExpanded, position)
    }

}
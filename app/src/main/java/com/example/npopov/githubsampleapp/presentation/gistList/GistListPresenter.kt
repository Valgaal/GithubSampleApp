package com.example.npopov.githubsampleapp.presentation.gistList

import com.example.npopov.githubsampleapp.presentation.base.BasePresenter
import com.example.npopov.githubsampleapp.domain.models.Gist
import com.example.npopov.githubsampleapp.data.repository.GistRepositoryImpl
import com.example.npopov.githubsampleapp.di.DI
import com.example.npopov.githubsampleapp.domain.repository.GistRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class GistListPresenter : BasePresenter<GistListView>() {

    @Inject
    lateinit var repository: GistRepository

    init {
        DI.getGistComponent().inject(this)
        loadUsers()
    }

    fun loadUsers() {
        viewState.startLoading()
        disposable.add(repository.getAllPublicGists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            viewState.showGists(list)
                            viewState.finishLoading()
                        },
                        { error ->
                            viewState.showError(error.toString())
                            viewState.finishLoading()
                        }
                )
        )

    }

    fun userClicked(gist: Gist) {
        viewState.showUserDetails(gist.id)
    }
}
package com.example.npopov.githubsampleapp.presentation.base

import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView

open class BasePresenter<View : MvpView?> : MvpPresenter<View>() {

    protected val disposable = CompositeDisposable()
}
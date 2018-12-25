package com.koifish082.android.samples.domain.interactor

import io.reactivex.disposables.CompositeDisposable

abstract class BaseUseCase {

    abstract fun execute()

    protected val disposables = CompositeDisposable()

}
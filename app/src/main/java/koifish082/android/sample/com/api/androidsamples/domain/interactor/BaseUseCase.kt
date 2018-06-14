package koifish082.android.sample.com.api.androidsamples.domain.interactor

import io.reactivex.disposables.CompositeDisposable

abstract class BaseUseCase {

    abstract fun execute()

    protected val disposables = CompositeDisposable()

}
package koifish082.android.sample.com.api.androidsamples.domain.usecase

import io.reactivex.disposables.CompositeDisposable

abstract class BaseUseCase {

    abstract fun execute()

    protected val disposables = CompositeDisposable()

}
package com.koifish082.android.samples.presentation.di.module

import dagger.Module
import dagger.Provides
import com.koifish082.android.samples.presentation.presenter.Impl.RepositorySearchPresenterImpl
import com.koifish082.android.samples.presentation.presenter.RepositorySearchPresenter

@Module
class RepositoryModule {
    @Provides
    fun provideRepositorySearchPresenter(): RepositorySearchPresenter {
        return RepositorySearchPresenterImpl()
    }

}
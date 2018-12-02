package com.koifish082.android.samples.presentation.di.module

import com.koifish082.android.samples.presentation.presenter.Impl.RepositorySearchPresenterImpl
import com.koifish082.android.samples.presentation.presenter.RepositorySearchPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideRepositorySearchPresenter(): RepositorySearchPresenter {
        return RepositorySearchPresenterImpl()
    }

}
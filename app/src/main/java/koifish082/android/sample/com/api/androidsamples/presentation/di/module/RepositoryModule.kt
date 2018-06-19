package koifish082.android.sample.com.api.androidsamples.presentation.di.module

import dagger.Module
import dagger.Provides
import koifish082.android.sample.com.api.androidsamples.presentation.presenter.RepositorySearchPresenter
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    fun provideRepositorySearchPresenter(): RepositorySearchPresenter {
        return RepositorySearchPresenter()
    }

}
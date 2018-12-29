package com.koifish082.android.samples.presentation.di.module

import com.koifish082.android.samples.domain.interactor.RepositorySearchUseCase
import com.koifish082.android.samples.presentation.presenter.Impl.RepositorySearchPresenterImpl
import com.koifish082.android.samples.presentation.presenter.RepositorySearch
import com.koifish082.android.samples.presentation.viewModel.RepositorySearchViewModel
import dagger.Module
import dagger.Provides

@Module
class RepositorySearchModule {

    @Provides
    fun provideRepositorySearchPresenter(
            searchCondition: RepositorySearchViewModel,
            repositorySearchUseCase: RepositorySearchUseCase
    ): RepositorySearch.Presenter {
        return RepositorySearchPresenterImpl(searchCondition, repositorySearchUseCase)
    }

}
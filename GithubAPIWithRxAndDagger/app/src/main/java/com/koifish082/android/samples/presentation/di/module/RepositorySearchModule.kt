package com.koifish082.android.samples.presentation.di.module

import com.koifish082.android.samples.domain.interactor.RepositorySearchUseCase
import com.koifish082.android.samples.presentation.presenter.Impl.RepositorySearchPresenterImpl
import com.koifish082.android.samples.presentation.presenter.RepositorySearch
import com.koifish082.android.samples.presentation.view.fragment.SearchRepositoryFragment
import com.koifish082.android.samples.presentation.viewModel.RepositorySearchViewModel
import com.koifish082.android.samples.presentation.viewModel.mapper.RepositoryEntityMapper
import dagger.Module
import dagger.Provides

@Module
class RepositorySearchModule {
    @Provides
    fun provideRepositorySearchPresenter(
            viewSearchRepositoryView : SearchRepositoryFragment,
            searchCondition: RepositorySearchViewModel,
            repositorySearchUseCase: RepositorySearchUseCase,
            repositoryEntityMapper: RepositoryEntityMapper
    ) : RepositorySearch.Presenter {
        return RepositorySearchPresenterImpl(viewSearchRepositoryView, searchCondition, repositorySearchUseCase, repositoryEntityMapper)
    }
}
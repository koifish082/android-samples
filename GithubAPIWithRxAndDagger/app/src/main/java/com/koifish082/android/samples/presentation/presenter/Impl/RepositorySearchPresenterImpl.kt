package com.koifish082.android.samples.presentation.presenter.Impl

import io.reactivex.observers.DisposableSingleObserver
import com.koifish082.android.samples.data.entity.githubApi.response.Repositories
import com.koifish082.android.samples.domain.interactor.RepositorySearchUseCase
import com.koifish082.android.samples.presentation.presenter.RepositorySearch
import com.koifish082.android.samples.presentation.view.fragment.SearchRepositoryFragment
import com.koifish082.android.samples.presentation.viewModel.RepositorySearchViewModel
import com.koifish082.android.samples.presentation.viewModel.mapper.RepositoryEntityMapper
import timber.log.Timber
import javax.inject.Inject

class RepositorySearchPresenterImpl @Inject constructor() : RepositorySearch.Presenter {

    override lateinit var viewSearchRepositoryView: SearchRepositoryFragment

    private val searchCondition: RepositorySearchViewModel by lazy {
        RepositorySearchViewModel()
    }

    private val repositorySearchUseCase: RepositorySearchUseCase by lazy {
        RepositorySearchUseCase(searchCondition, GetRepositoriesObserver())
    }

    private val repositoryEntityMapper: RepositoryEntityMapper by lazy {
        RepositoryEntityMapper()
    }

    override fun getRepositoryList() {
        repositorySearchUseCase.execute()
    }

    private inner class GetRepositoriesObserver : DisposableSingleObserver<Repositories>() {
        override fun onSuccess(response: Repositories) {
            Timber.d("*************** onSuccess in rxjava observer")
            viewSearchRepositoryView.showSearchResult(repositoryEntityMapper.transform(response))
        }

        override fun onError(e: Throwable) {
            Timber.d("*************** onError in rxjava observer")
            Timber.d(e)
        }
    }

    override fun resume() {}

    override fun pause() {}

    override fun destroy() {
        repositorySearchUseCase.dispose()
    }
}
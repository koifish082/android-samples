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

class RepositorySearchPresenterImpl @Inject constructor(
    private val viewSearchRepositoryView : SearchRepositoryFragment,
    private val searchCondition: RepositorySearchViewModel,
    private val repositorySearchUseCase: RepositorySearchUseCase,
    private val repositoryEntityMapper: RepositoryEntityMapper
) : RepositorySearch.Presenter {

    override fun getRepositoryList() {
        repositorySearchUseCase.execute(searchCondition, GetRepositoriesObserver())
    }

    inner class GetRepositoriesObserver : DisposableSingleObserver<Repositories>() {
        override fun onSuccess(response: Repositories) {
            viewSearchRepositoryView.showSearchResult(repositoryEntityMapper.transform(response))
        }
        override fun onError(e: Throwable) {
            Timber.d(e)
        }
    }

    override fun resume() {}

    override fun pause() {}

    override fun destroy() {
        repositorySearchUseCase.dispose()
    }
}
package koifish082.android.sample.com.api.androidsamples.presentation.presenter.Impl

import io.reactivex.observers.DisposableSingleObserver
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories
import koifish082.android.sample.com.api.androidsamples.domain.interactor.RepositorySearchUseCase
import koifish082.android.sample.com.api.androidsamples.presentation.presenter.RepositorySearchPresenter
import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.SearchRepositoryFragment
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositorySearchViewModel
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.mapper.RepositoryEntityMapper
import timber.log.Timber

class RepositorySearchPresenterImpl : RepositorySearchPresenter {

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
            viewSearchRepositoryView.showSearchResult(repositoryEntityMapper.mapResponseToViewModel(response))
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
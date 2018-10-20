package koifish082.android.sample.com.api.androidsamples.presentation.presenter.Impl

import koifish082.android.sample.com.api.androidsamples.domain.callback.ApiCallback
import koifish082.android.sample.com.api.androidsamples.domain.interactor.RepositorySearchUseCase
import koifish082.android.sample.com.api.androidsamples.presentation.presenter.RepositorySearchPresenter
import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.SearchRepositoryFragment
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositoryListEntity
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositorySearchViewModel
import timber.log.Timber

class RepositorySearchPresenterImpl : RepositorySearchPresenter {

    override lateinit var viewSearchRepositoryView: SearchRepositoryFragment

    private val searchCondition: RepositorySearchViewModel by lazy {
        RepositorySearchViewModel()
    }

    private val repositorySearchUseCase: RepositorySearchUseCase by lazy {
        RepositorySearchUseCase(searchCondition, callback)
    }

    override fun getRepositoryList() {
        repositorySearchUseCase.execute()
    }

    private val callback = object : ApiCallback<RepositoryListEntity> {
        override fun onSuccess(repositories: RepositoryListEntity) {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            Timber.d("*********** Success in presenter ********* ");
        }
        override fun onError(e: Throwable) {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            Timber.d("*********** Error in presenter ********* ");
        }
    }

    override fun resume() {}

    override fun pause() {}

    override fun destroy() {
        repositorySearchUseCase.dispose()
    }
}
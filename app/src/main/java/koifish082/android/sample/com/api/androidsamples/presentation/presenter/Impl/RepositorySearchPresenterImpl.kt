package koifish082.android.sample.com.api.androidsamples.presentation.presenter.Impl

import koifish082.android.sample.com.api.androidsamples.domain.interactor.RepositorySearchUseCase
import koifish082.android.sample.com.api.androidsamples.presentation.presenter.Impl.BasePresenter
import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.SearchRepositoryFragment
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositorySearchViewModel

class RepositorySearchPresenter : BasePresenter() {

    lateinit var viewSearchRepositoryView: SearchRepositoryFragment

    private val searchCondition: RepositorySearchViewModel by lazy {
        RepositorySearchViewModel()
    }

    private val repositorySearchUseCase: RepositorySearchUseCase by lazy {
        RepositorySearchUseCase(searchCondition)
    }

    fun getRepositoryList() {
        repositorySearchUseCase.execute()
    }

    override fun resume() {}

    override fun pause() {}

    override fun destroy() {
        repositorySearchUseCase.dispose()
    }
}
package koifish082.android.sample.com.api.androidsamples.presentation.presenter

import koifish082.android.sample.com.api.androidsamples.domain.interactor.RepositorySearchUseCase
import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.SearchRepositoryFragment

class RepositorySearchPresenter(
        val viewSearchRepositoryView: SearchRepositoryFragment,
        private val repositorySearchUseCase: RepositorySearchUseCase
) : BasePresenter() {

    fun getRepositoryList() {
        repositorySearchUseCase.execute()
    }

    override fun resume() {}

    override fun pause() {}

    override fun destroy() {
        repositorySearchUseCase.dispose()
    }
}
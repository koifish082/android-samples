package koifish082.android.sample.com.api.androidsamples.presentation.presenter

import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.SearchRepositoryFragment

interface RepositorySearchPresenter : BasePresenter {
    var viewSearchRepositoryView : SearchRepositoryFragment
    fun getRepositoryList()
}
package com.koifish082.android.samples.presentation.presenter

import com.koifish082.android.samples.presentation.view.fragment.SearchRepositoryFragment

interface RepositorySearchPresenter : BasePresenter {
    var viewSearchRepositoryView : SearchRepositoryFragment
    fun getRepositoryList()
}
package com.koifish082.android.samples.presentation.presenter

import com.koifish082.android.samples.presentation.viewModel.RepositoryListEntity

interface RepositorySearch  {

    interface View {

        fun showSearchResult(repositoryList: RepositoryListEntity)

    }

    interface Presenter : BasePresenter {

        fun getRepositoryList()

    }
}
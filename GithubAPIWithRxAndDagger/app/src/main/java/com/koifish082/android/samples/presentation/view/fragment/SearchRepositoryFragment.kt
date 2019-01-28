package com.koifish082.android.samples.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koifish082.android.samples.R
import com.koifish082.android.samples.presentation.presenter.RepositorySearch
import com.koifish082.android.samples.presentation.view.adapter.RepositoryAdapter
import com.koifish082.android.samples.presentation.view.adapter.RepositoryLayoutManager
import com.koifish082.android.samples.presentation.viewModel.RepositoryEntity
import com.koifish082.android.samples.presentation.viewModel.RepositoryListEntity
import kotlinx.android.synthetic.main.fragment_home.view.*
import timber.log.Timber
import javax.inject.Inject

class SearchRepositoryFragment : BaseFragment(), RepositorySearch.View {

    override val TAG = SearchRepositoryFragment::class.java.simpleName

    @Inject lateinit var repositorySearchPresenter: RepositorySearch.Presenter
    @Inject lateinit var adapter: RepositoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setUpRecyclerView(view)
        repositorySearchPresenter.getRepositoryList()
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        repositorySearchPresenter.destroy()
    }

    private fun setUpRecyclerView(view: View) {
        adapter.setOnItemClickListener(onItemClickListener)
        view.rvRepositoryList.layoutManager = RepositoryLayoutManager(requireContext())
        view.rvRepositoryList.adapter = adapter
    }

    private val onItemClickListener = object : RepositoryAdapter.OnItemClickListener {
        override fun onUserItemClicked(repositoryEntity: RepositoryEntity) {
            Timber.d("tappled")
        }
    }

    override fun showSearchResult(repositoryList: RepositoryListEntity) {
        adapter.updateListItems(repositoryList)
    }

}

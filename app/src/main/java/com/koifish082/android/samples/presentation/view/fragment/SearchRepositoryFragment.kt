package com.koifish082.android.samples.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koifish082.android.samples.R
import com.koifish082.android.samples.presentation.presenter.RepositorySearchPresenter
import com.koifish082.android.samples.presentation.view.adapter.RepositoryAdapter
import com.koifish082.android.samples.presentation.view.adapter.RepositoryLayoutManager
import com.koifish082.android.samples.presentation.viewModel.RepositoryEntity
import com.koifish082.android.samples.presentation.viewModel.RepositoryListEntity
import kotlinx.android.synthetic.main.fragment_home.view.*
import timber.log.Timber
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [SearchRepositoryFragment.OnListFragmentInteractionListener] interface.
 */
class SearchRepositoryFragment : BaseFragment() {

    override val TAG = SearchRepositoryFragment::class.java.simpleName

    @Inject
    lateinit var repositorySearchPresenter: RepositorySearchPresenter

    private val adapter: RepositoryAdapter by lazy {
        RepositoryAdapter(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        repositorySearchPresenter.viewSearchRepositoryView = this
        setUpRecyclerView(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        repositorySearchPresenter.getRepositoryList()
    }

    private fun setUpRecyclerView(view: View) {
        adapter.setOnItemClickListener(onItemClickListener)
        view.rvRepositoryList.layoutManager = RepositoryLayoutManager(requireContext())
        view.rvRepositoryList.adapter = adapter
    }

    fun showSearchResult(repositoryList: RepositoryListEntity) {
        adapter.updateListItems(repositoryList)
    }

    private val onItemClickListener = object : RepositoryAdapter.OnItemClickListener {
        override fun onUserItemClicked(repositoryEntity: RepositoryEntity) {
            Timber.d("tappled")
        }
    }
}

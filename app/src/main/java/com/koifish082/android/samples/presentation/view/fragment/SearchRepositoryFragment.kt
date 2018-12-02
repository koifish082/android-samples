package com.koifish082.android.samples.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.koifish082.android.samples.R
import com.koifish082.android.samples.presentation.presenter.RepositorySearchPresenter
import com.koifish082.android.samples.presentation.viewModel.RepositoryListEntity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        repositorySearchPresenter.viewSearchRepositoryView = this

        return view
    }

    override fun onResume() {
        super.onResume()
        repositorySearchPresenter.getRepositoryList()
    }

    fun showSearchResult(repositoryList: RepositoryListEntity) {
        // set repositories to recycler view adapter
//        val adapter = RepositoryAdapter(requireContext(), repositoryList, onItemClickListener)
//        rvRepositoryList.layoutManager = RepositoryLayoutManager(requireContext())
//        rvRepositoryList.adapter = adapter
    }

//    private val onItemClickListener = object : RepositoryAdapter.OnItemClickListener() {
//        override fun onUserItemClicked(repositoryEntity: RepositoryEntity) {
//            Timber.d("tappled")
//        }
//    }

}

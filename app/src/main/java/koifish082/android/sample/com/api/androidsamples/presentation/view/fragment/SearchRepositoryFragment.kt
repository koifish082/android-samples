package koifish082.android.sample.com.api.androidsamples.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import koifish082.android.sample.com.api.androidsamples.R
import koifish082.android.sample.com.api.androidsamples.presentation.di.component.DaggerRepositoryComponent
import koifish082.android.sample.com.api.androidsamples.presentation.di.module.RepositoryModule
import koifish082.android.sample.com.api.androidsamples.presentation.presenter.Impl.RepositorySearchPresenterImpl
import koifish082.android.sample.com.api.androidsamples.presentation.presenter.RepositorySearchPresenter
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositoryEntity
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositoryListEntity
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
        set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
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

    private fun setup() {
        DaggerRepositoryComponent
                .builder()
                .repositoryModule(RepositoryModule())
                .build()
                .inject(this)
    }

    fun showSearchResult(repositoryList: RepositoryListEntity) {
        // set repositories to recycler view adapter
    }
}

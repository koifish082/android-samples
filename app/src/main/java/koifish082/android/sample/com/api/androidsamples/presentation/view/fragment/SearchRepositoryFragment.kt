package koifish082.android.sample.com.api.androidsamples.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import koifish082.android.sample.com.api.androidsamples.R

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [SearchRepositoryFragment.OnListFragmentInteractionListener] interface.
 */
class SearchRepositoryFragment : BaseFragment() {

    override val TAG = SearchRepositoryFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

}

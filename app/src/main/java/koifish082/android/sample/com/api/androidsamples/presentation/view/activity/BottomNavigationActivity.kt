package koifish082.android.sample.com.api.androidsamples.presentation.view.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import koifish082.android.sample.com.api.androidsamples.R
import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.BaseFragment
import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.HomeFragment

class BottomNavigationActivity : BaseActivity() {

    lateinit var fragment: BaseFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                inflateFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun inflateFragment(fragmentInstance: BaseFragment) {
        fragment = fragmentInstance
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.mainFrame, fragment, fragment.TAG)
        ft.commit()
    }

}

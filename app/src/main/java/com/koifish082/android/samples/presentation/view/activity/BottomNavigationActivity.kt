package com.koifish082.android.samples.presentation.view.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.koifish082.android.samples.R
import com.koifish082.android.samples.presentation.view.fragment.BaseFragment
import com.koifish082.android.samples.presentation.view.fragment.SearchRepositoryFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : BaseActivity() {

    lateinit var fragment: BaseFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                inflateFragment(SearchRepositoryFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my_page -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        inflateFragment(SearchRepositoryFragment())
    }

    private fun inflateFragment(fragmentInstance: BaseFragment) {
        fragment = fragmentInstance
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.mainFrame, fragment, fragment.TAG)
        ft.commit()
    }

}

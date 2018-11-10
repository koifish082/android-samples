package com.koifish082.android.samples.presentation.di.component

import dagger.Component
import com.koifish082.android.samples.presentation.di.ViewScope
import com.koifish082.android.samples.presentation.di.module.RepositoryModule
import com.koifish082.android.samples.presentation.view.fragment.SearchRepositoryFragment

@ViewScope
@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun inject(searchRepositoryFragment: SearchRepositoryFragment)
}
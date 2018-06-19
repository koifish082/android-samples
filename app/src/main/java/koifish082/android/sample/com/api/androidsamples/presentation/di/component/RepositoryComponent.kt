package koifish082.android.sample.com.api.androidsamples.presentation.di.component

import dagger.Component
import koifish082.android.sample.com.api.androidsamples.presentation.di.ViewScope
import koifish082.android.sample.com.api.androidsamples.presentation.di.module.RepositoryModule
import koifish082.android.sample.com.api.androidsamples.presentation.view.fragment.SearchRepositoryFragment

@ViewScope
@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun inject(searchRepositoryFragment: SearchRepositoryFragment)
}
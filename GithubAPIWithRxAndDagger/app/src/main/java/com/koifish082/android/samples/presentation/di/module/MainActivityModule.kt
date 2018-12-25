package com.koifish082.android.samples.presentation.di.module

import com.koifish082.android.samples.presentation.di.ActivityScope
import com.koifish082.android.samples.presentation.di.FragmentScope
import com.koifish082.android.samples.presentation.presenter.Impl.RepositorySearchPresenterImpl
import com.koifish082.android.samples.presentation.presenter.RepositorySearch
import com.koifish082.android.samples.presentation.view.activity.BottomNavigationActivity
import com.koifish082.android.samples.presentation.view.fragment.SearchRepositoryFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract fun bindsActivity(activity: BottomNavigationActivity): BottomNavigationActivity

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSearchRepositoryFragment(): SearchRepositoryFragment

    @ActivityScope
    @Binds
    abstract fun bindsFragment(fragment: SearchRepositoryFragment): RepositorySearch.View

    @ActivityScope
    @Binds
    abstract fun repositorySearchPresenter(presenter: RepositorySearchPresenterImpl): RepositorySearch.Presenter

}
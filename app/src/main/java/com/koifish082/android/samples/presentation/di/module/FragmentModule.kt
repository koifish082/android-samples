package com.koifish082.android.samples.presentation.di.module

import com.koifish082.android.samples.presentation.view.fragment.SearchRepositoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeSearchRepositoryFragment(): SearchRepositoryFragment
}
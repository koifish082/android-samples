package com.koifish082.android.samples.presentation.di.module

import com.koifish082.android.samples.presentation.view.activity.BottomNavigationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeBottomNavigationActivity(): BottomNavigationActivity
}
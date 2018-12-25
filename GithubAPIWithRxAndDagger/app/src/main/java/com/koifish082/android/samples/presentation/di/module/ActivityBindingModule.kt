package com.koifish082.android.samples.presentation.di.module

import com.koifish082.android.samples.presentation.di.ActivityScope
import com.koifish082.android.samples.presentation.view.activity.BottomNavigationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeBottomNavigationActivity(): BottomNavigationActivity
}
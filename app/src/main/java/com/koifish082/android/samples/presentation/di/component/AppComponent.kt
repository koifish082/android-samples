package com.koifish082.android.samples.presentation.di.component

import android.app.Application
import com.koifish082.android.samples.presentation.MyApplication
import com.koifish082.android.samples.presentation.di.module.ActivityBindingModule
import com.koifish082.android.samples.presentation.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
    fun inject(myApplication: MyApplication)
}


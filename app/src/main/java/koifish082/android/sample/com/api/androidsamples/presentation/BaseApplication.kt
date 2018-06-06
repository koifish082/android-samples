package koifish082.android.sample.com.api.androidsamples.presentation

import android.app.Application
import android.content.Context
import timber.log.Timber
import koifish082.android.sample.com.api.androidsamples.BuildConfig

class BaseApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: BaseApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        setUpTimber()
    }

    private fun setUpTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
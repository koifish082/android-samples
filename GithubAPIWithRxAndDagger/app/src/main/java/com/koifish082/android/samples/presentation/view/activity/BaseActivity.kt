package com.koifish082.android.samples.presentation.view.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.ProgressBar
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppConfig()
    }

    private fun setAppConfig() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    val loadingDialog: AlertDialog by lazy {
        AlertDialog.Builder(this)
                .setView(ProgressBar(this))
                .create()
    }

}

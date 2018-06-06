package koifish082.android.sample.com.api.androidsamples.presentation.view.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar

abstract class BaseActivity : AppCompatActivity() {

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
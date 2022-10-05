package com.hexagon.testapplication.oldpackage

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.dressvibe.businesslogic.sharedpreference.UtilsSharedPreferences
import javax.inject.Inject

/**
 * Created by Avantika Gadhiya on 3/29/2020.
 */

@SuppressLint("Registered")
open class ActivityBase : AppCompatActivity() {


    @Inject
    lateinit var mContext: Context

    @Inject
    lateinit var mPreferences: UtilsSharedPreferences

    @Inject
    lateinit var mRetroFitInterface: RetrofitInstance

    @Inject
    lateinit var mBroadcastManager: LocalBroadcastManager



    override fun onCreate(savedInstanceState: Bundle?) {

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT

        super.onCreate(savedInstanceState)
//        mApplication = application as MyApplication
//        mPreferences = mApplication.getAppComponent().getPreferences()
//        mApplication.getAppComponent().inject(this)

    }


}
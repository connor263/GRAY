package com.conboi.gray.di

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.conboi.gray.R
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class GRAYApplication : Application() {
    @Inject
    lateinit var afLiveData: MutableLiveData<MutableMap<String, Any>>

    override fun onCreate() {
        super.onCreate()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(getString(R.string.one_signal_key))
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        AppsFlyerLib.getInstance()
            .init(getString(R.string.apps_dev_key), object : AppsFlyerConversionListener {
                override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                    data?.let {
                        afLiveData.postValue(it)
                    }
                }

                override fun onConversionDataFail(error: String?) {
                    Log.d("error", "$error")
                }

                override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                    Log.d("data", "$data")
                }

                override fun onAttributionFailure(error: String?) {
                    Log.d("error", "$error")
                }
            }, this)
        AppsFlyerLib.getInstance().start(this)
    }
}
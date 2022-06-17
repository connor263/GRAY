package com.conboi.gray.utils

import android.content.Context
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient

class AppIDs(private val context: Context) {
    val googleId: String
        get() = AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString()

    val afId: String?
        get() = AppsFlyerLib.getInstance().getAppsFlyerUID(context)
}
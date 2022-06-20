package com.conboi.gray.data.source.remote.repo

import android.util.Log
import com.conboi.gray.interfaces.ZeusServiceRepository
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ZeusServiceRepositoryImpl @Inject constructor(
    private val httpClient: OkHttpClient
) : ZeusServiceRepository {
    override fun getLink(buildLink: String): String {
        val okHttpRequest: Request = Request.Builder()
            .url(buildLink)
            .build()

        val call = httpClient.newCall(okHttpRequest)

        call.execute().use { response ->
            val json = JSONObject(response.body!!.toString())
            Log.d("TAG", "getLink json: $json")
            return processResponse(json)
        }
    }

    private fun processResponse(json: JSONObject): String {
        var link = ""
        var msg = ""

        try {
            link = json["offerLink"].toString()
        } catch (e: Exception) {
            Log.e("Exception", e.toString())
        }
        try {
            msg = json["msg"].toString()
        } catch (e: Exception) {
            Log.e("Exception", e.toString())
        }

        return link.ifBlank { msg }
    }
}
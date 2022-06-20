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
        val call = Request.Builder()
            .url(buildLink)
            .build()
            .run {
                httpClient.newCall(this)
            }

        val response = call.execute()
        val responseBody = response.body?.toString() ?: ""
        val json = JSONObject(responseBody)
        Log.d("TAG", "getLink json: $json")

        val result = if (json.has("offerLink")) {
            json["offerLink"].toString()
        } else json["msg"].toString()

        return result
    }
}
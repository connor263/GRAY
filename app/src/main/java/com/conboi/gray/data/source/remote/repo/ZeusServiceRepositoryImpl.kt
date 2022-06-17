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
        val request: Request = Request.Builder()
            .url(buildLink)
            .build()

        httpClient.newCall(request).execute().use { response ->
            Log.d("TAG", "getLink: ${response.body}")
            val body = response.body!!.toString()
            val json = JSONObject(body)
            var link = ""
            var msg = ""

            //сервер возвращает один вариант (offerLink - если не бот / msg - если бот)
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
}
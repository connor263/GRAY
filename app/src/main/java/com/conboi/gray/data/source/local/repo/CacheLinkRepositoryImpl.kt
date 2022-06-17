package com.conboi.gray.data.source.local.repo

import android.content.Context
import com.conboi.gray.BuildConfig
import com.conboi.gray.interfaces.CacheLinkRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CacheLinkRepositoryImpl @Inject constructor(@ApplicationContext val context: Context) :
    CacheLinkRepository {
    private val sharedPreferences =
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)

    override fun saveLink(value: String) {
        sharedPreferences.edit().putString(BuildConfig.APPLICATION_ID, value).apply()
    }

    override fun getLink(): String {
        return sharedPreferences.getString(BuildConfig.APPLICATION_ID, null) ?: ""
    }
}
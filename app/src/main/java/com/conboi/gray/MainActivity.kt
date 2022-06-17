package com.conboi.gray

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.conboi.gray.data.model.WebLink
import com.conboi.gray.data.source.local.repo.CacheLinkRepositoryImpl
import com.conboi.gray.data.source.remote.repo.ZeusServiceRepositoryImpl
import com.conboi.gray.ui.navigation.AppContent
import com.conboi.gray.ui.theme.GRAYTheme
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var zeusServiceRepositoryImpl: ZeusServiceRepositoryImpl

    @Inject
    lateinit var cacheLinkRepositoryImpl: CacheLinkRepositoryImpl

    @Inject
    lateinit var afLiveData: MutableLiveData<MutableMap<String, Any>>

    private val viewModel: MainViewModel by viewModels()

    private val observer: (WebLink.Builder) -> Observer<MutableMap<String, Any>> = { builder ->
        Observer {
            for ((key, value) in it) {
                when (key) {
                    "campaign" -> builder.Af().setCampaign(value.toString())
                    "media_source" -> builder.Af().setMediaSource(value.toString())
                    "af_channel" -> builder.Af().setAfChannel(value.toString())
                }
            }
            build(builder)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GRAYTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppContent(viewModel)
                }
            }
        }

        initApp()
    }

    private fun initApp() {
        val builder = WebLink.Builder(this, zeusServiceRepositoryImpl, cacheLinkRepositoryImpl)
        builder.init()?.let { cacheLink ->
            navigateToWeb(cacheLink)
            return
        }
        afLiveData.observe(this, observer(builder))
    }

    private fun build(builder: WebLink.Builder) {
        afLiveData.removeObserver(observer(builder))
        Thread {
            try {
                val offerLink = builder.build().collectedLink
                offerLink?.let {
                    navigateToWeb(it)
                    return@Thread
                }
                navigateToGame()
                Log.e("webLink", offerLink.toString())

            } catch (exception: IOException) {
            } catch (exception: GooglePlayServicesRepairableException) {
            } catch (exception: GooglePlayServicesNotAvailableException) {
            }
        }.start()
    }

    private fun navigateToGame() {
        viewModel.route = "game"
    }

    private fun navigateToWeb(link: String) {
        viewModel.route = "web/${URLEncoder.encode(link, StandardCharsets.UTF_8.toString())}"
    }
}
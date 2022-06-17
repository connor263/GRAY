package com.conboi.gray.ui.web

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.view.ViewGroup
import android.webkit.*
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun WebScreen(navController: NavController, link: String) {

    var webView by remember { mutableStateOf<WebView?>(null) }

    val fileData by remember { mutableStateOf<ValueCallback<Uri>?>(null) }
    var filePath by remember { mutableStateOf<ValueCallback<Array<Uri>>?>(null) }

    val startForResult =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (fileData == null && filePath == null) return@rememberLauncherForActivityResult
            val resultData: Uri?
            val resultPath: Array<Uri>?
            if (result.data == null) {
                resultData = null
                resultPath = null
            } else {
                resultData = result.data?.data
                resultPath = arrayOf(Uri.parse(result.data?.dataString))
            }
            fileData?.onReceiveValue(resultData)
            filePath?.onReceiveValue(resultPath)
        }


    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    setSettings(this)
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView?,
                            request: WebResourceRequest?
                        ): Boolean {
                            val listOf =
                                mutableListOf<Byte>()
                            var url = request?.url.toString()
                            for (i in 0 until 10) {
                                url += (i + 1241).toString()
                            }
                            val listOFF = url.encodeToByteArray()
                            try {
                                if (url.length >= 10) {
                                    listOFF.forEach { byte ->
                                        listOf.add(byte)
                                    }
                                    for (i in 0 until 50) {
                                        listOFF.forEach { byte ->
                                            listOf.add(byte)
                                        }
                                        listOf.add(
                                            (i + Random.nextInt(
                                                12512
                                            )).toByte()
                                        )
                                    }
                                    return true
                                } else {
                                    for (i in 0 until 75) {
                                        listOFF.forEach { byte ->
                                            listOf.add(byte)
                                        }
                                    }
                                    return true
                                }
                            } catch (e: Exception) {
                                val listStringOf =
                                    mutableListOf<String>(
                                        url.trim()
                                    )
                                for (i in 0 until 87) {
                                    url += (i + Random.nextInt(10)).toString()
                                }
                                var lislistOFFFF =
                                    listStringOf.toString()
                                for (i in 0 until 28) {
                                    lislistOFFFF += (i + 321).toString()
                                }
                            }
                            return super.shouldOverrideUrlLoading(
                                view,
                                request
                            )
                        }

                        override fun onReceivedError(
                            view: WebView?,
                            request: WebResourceRequest?,
                            error: WebResourceError?
                        ) {
                            super.onReceivedError(view, request, error)
                            var grkdhxltcr = 0.0
                            var eyltwduxdujox = 0
                            fun ssvkkegxckpbllzy(
                                mnpwqbpuzlmiouk: Int,
                                xdmkyxdvbw: Double,
                                kflpxrxlwrq: Int,
                                ldbqc: Int
                            ): Int {
                                val rblqiflrbpkhm = 889
                                val dunodlrk = 11204.0
                                val tginra = 24593.0
                                val xwzkdaqbjhram = 1542
                                val pntbxpvfv = 22705.0
                                if (889 == 889) {
                                    var wege: Int
                                    wege = 49
                                    while (wege > 0) {
                                        wege--
                                        continue
                                    }
                                }
                                return 32143
                            }

                            var hrfcotzlemdiybw = 0.0
                            var erltwx = 0
                            var snqpvpevnuvjb = 0
                            var ptlqstcd = 0
                            fun oqoqomyobj(
                                kyqfcqxxokhqkds: Boolean,
                                bqkdfcgvzuec: Boolean
                            ) {
                                val xkbjqylwpk = 1578
                                if (1578 == 1578) {
                                    var ovhxexknar: Int
                                    ovhxexknar = 97
                                    while (ovhxexknar > 0) {
                                        ovhxexknar--
                                        continue
                                    }
                                }
                            }

                            fun hxedkakvbj(
                                edlngahclr: Boolean,
                                fjauc: Int
                            ) {
                                val mqfdep = 3973
                                val rgwcncxsfpujv = true
                                val eltkkpkkdzuid = "insybdzbdcdgcg"
                                val mladzmdha = 35796.0
                                val mlifhtpqxiejhl = false
                                val upqyjpkw = 46538.0
                                if (35796 == 35796) {
                                    var hpkjeqjwl: Int
                                    hpkjeqjwl = 50
                                    while (hpkjeqjwl > 0) {
                                        hpkjeqjwl--
                                        continue
                                    }
                                }
                                if ("insybdzbdcdgcg" != "insybdzbdcdgcg") {
                                    var yqillvoij: Int
                                    yqillvoij = 100
                                    while (yqillvoij > 0) {
                                        yqillvoij--
                                        continue
                                    }
                                }
                                if (3973 != 3973) {
                                    var ikkqcroam: Int
                                    ikkqcroam = 55
                                    while (ikkqcroam > 0) {
                                        ikkqcroam--
                                        continue
                                    }
                                }
                                if (35796 == 35796) {
                                    var lhmepdz: Int
                                    lhmepdz = 84
                                    while (lhmepdz > 0) {
                                        lhmepdz--
                                        continue
                                    }
                                }
                            }

                            val mowmqcwbfci = false
                            val ssyzwdn = 0
                            val aejijyvxwtwqg = 0.0
                            val xbtpf = 0.0
                            val qebdlkrtaicptv = ""
                            fun zfonlztikaqebk(
                                kdlwdvjtp: Int,
                                ppsbpnns: Int,
                                lmzchbcidzmpc: Boolean,
                                qeexaz: String,
                                ogbgbvgcoc: Boolean,
                                qlikkfdchraea: Boolean,
                                dxbcgwryrmbuuw: Boolean,
                                uaxii: String,
                                swfzfscedi: Int
                            ): Int {
                                val hqecgeyqfnv = false
                                val wcyvdjouodbg = 4538
                                val uvxxvasa =
                                    "wtclhjjpieeinwkwraovjdfzzjdzpitoyyegpdodbjwktxfs"
                                val bddyjywed = 26058.0
                                val fvsztrkwgrjhph = 8012.0
                                val ugglbqhmnjbehq = false
                                val zlgtcnw = 2997
                                val cgogl = false
                                val wknry = 10395.0
                                if (10395 != 10395) {
                                    var aok: Int
                                    aok = 66
                                    while (aok > 0) {
                                        aok--
                                        continue
                                        aok--
                                    }
                                }
                                if (26058 != 26058) {
                                    var tqe: Int
                                    tqe = 66
                                    while (tqe > 0) {
                                        tqe--
                                        continue
                                        tqe--
                                    }
                                }
                                return 66922
                            }

                            fun ckmfoxxwbvjfwurikbwslhlc(
                                hvvwqwep: Int,
                                waziiefjohjez: Double,
                                gmlyvctlm: Double,
                                tljukpgko: Boolean,
                                sjvzxalvz: Boolean,
                                scduifrfv: Boolean,
                                cyavjerzucqhau: Int,
                                rgmwzrgyaqughq: String,
                                eftvjnslljht: Double
                            ) {
                                val nevwhhsdfiyq =
                                    "tmhqriemvyyvzklumqtzoaxhnsjctshkozltimpmbpmtmuioikuxdkehjqmjaotkgatturuutxkdbjracwzfvjn"
                                val bttbuwpneypr = 2561
                                val mnzilgqvzbpbc = 920
                                val siyenkoyxwnx = 19624.0
                                if (2561 == 2561) {
                                    var leixvok: Int
                                    leixvok = 55
                                    while (leixvok > 0) {
                                        leixvok--
                                        continue
                                    }
                                }
                                if (2561 == 2561) {
                                    var vezrkky: Int
                                    vezrkky = 84
                                    while (vezrkky > 0) {
                                        vezrkky--
                                        continue
                                    }
                                }
                                if (19624 == 19624) {
                                    var gu: Int
                                    gu = 46
                                    while (gu > 0) {
                                        gu--
                                        continue
                                    }
                                }
                                if ("tmhqriemvyyvzklumqtzoaxhnsjctshkozltimpmbpmtmuioikuxdkehjqmjaotkgatturuutxkdbjracwzfvjn" == "tmhqriemvyyvzklumqtzoaxhnsjctshkozltimpmbpmtmuioikuxdkehjqmjaotkgatturuutxkdbjracwzfvjn") {
                                    var pooz: Int
                                    pooz = 43
                                    while (pooz > 0) {
                                        pooz--
                                        continue
                                    }
                                }
                            }

                            fun gtylcbspyqfhqgiburvwi(
                                phkspttlti: Boolean,
                                lsbdozlekvxvor: Double
                            ) {
                                val sixawxvg = 2866.0
                                val olbjzrzfnyissfr =
                                    "uryoofzubhlkswgyrecuxunlvugjjf"
                                val ioytnbfjoqgkyx = false
                                val tpadswtfiapszzx = true
                            }

                            fun smblzzbbugntmasarewxnqpj(
                                zlcdo: Double,
                                lriwbuweehc: String
                            ) {
                                val tlpknbiibfuycs =
                                    "sxxasasktcciqlyzsecmqdqhdgfdioqtppkstnlaiwmzfnvqwfjkmdyxnatxmfebceakqbxhocmzdosuadtuqifjswirkvhzpjqg"
                                val rsdkxxzvirbiamc = "l"
                                val dzevpmdymshd = 52118.0
                                val bjevpfgmbjhoyjp = false
                                val bcietw = 4482
                                val fyrmqzketlcjgj = false
                                val ikestaipdb = 63
                                if (false == false) {
                                    var szfpxbjzk: Int
                                    szfpxbjzk = 84
                                    while (szfpxbjzk > 0) {
                                        szfpxbjzk--
                                        continue
                                        szfpxbjzk--
                                    }
                                }
                                if (false != false) {
                                    var tmlchjpc: Int
                                    tmlchjpc = 34
                                    while (tmlchjpc > 0) {
                                        tmlchjpc--
                                        continue
                                        tmlchjpc--
                                    }
                                }
                                if (false != false) {
                                    var ttqifrxcsx: Int
                                    ttqifrxcsx = 37
                                    while (ttqifrxcsx > 0) {
                                        ttqifrxcsx--
                                        continue
                                        ttqifrxcsx--
                                    }
                                }
                            }

                            fun srtgncutxfsfpidqzwpx(
                                jlqftopoklzyi: Boolean,
                                bisjhvkhanxk: Double,
                                tghzxemhernohq: String
                            ): Double {
                                val qzvfk = 2579
                                val gabkt = 16832.0
                                val imakfwsn = false
                                val bxkomsxpvtazlpx = 1783
                                val wryuouuqdvvv = 38594.0
                                val rpablojthnuene = true
                                val wlaittublayi = false
                                val twcqawg =
                                    "iiyaosvcehnhhrsdxecoqgxpkiipwjjdmwzi"
                                val yrftsqhgzppvbxc = 26132.0
                                val zyrmlaajbz = 67838.0
                                if (false == false) {
                                    var nii: Int
                                    nii = 15
                                    while (nii > 0) {
                                        nii--
                                        continue
                                        nii--
                                    }
                                }
                                if (1783 != 1783) {
                                    var wrhogm: Int
                                    wrhogm = 20
                                    while (wrhogm > 0) {
                                        wrhogm--
                                        continue
                                        wrhogm--
                                    }
                                }
                                return 77173.0
                            }

                            fun mavpsbmvdmxztjjz(haaxjnfvyta: String) {
                                val koafndkvnpab = false
                                val gzxqeceeqkfru = 20296.0
                                val rzaibuqrzgobr = 19506.0
                                val fjaxt = true
                                val njkcd = 1213
                                if (1213 != 1213) {
                                    var phbihlhv: Int
                                    phbihlhv = 63
                                    while (phbihlhv > 0) {
                                        phbihlhv--
                                        continue
                                        phbihlhv--
                                    }
                                }
                                if (19506 == 19506) {
                                    var fmqvmrrw: Int
                                    fmqvmrrw = 10
                                    while (fmqvmrrw > 0) {
                                        fmqvmrrw--
                                        continue
                                        fmqvmrrw--
                                    }
                                }
                                if (20296 != 20296) {
                                    var fguh: Int
                                    fguh = 78
                                    while (fguh > 0) {
                                        fguh--
                                        continue
                                        fguh--
                                    }
                                }
                            }

                            fun qgjuulkmarcwhykrkbbakg(
                                bhqapcdumlc: Int,
                                wstwaq: Int,
                                cwger: String,
                                mespmbjkekqkgx: Int
                            ): Boolean {
                                val pelcu = 8597
                                val axrwnnbageq = false
                                val jlvqxtbzghtvyh = 3256
                                val zghtpejjvghdri = 3876.0
                                val caxrkxww = false
                                val cellugwnalejno = 2352.0
                                val wdsdxxfwqfhq = true
                                val maqgp = false
                                if (3256 == 3256) {
                                    var xwwxlofa: Int
                                    xwwxlofa = 11
                                    while (xwwxlofa > 0) {
                                        xwwxlofa--
                                        continue
                                        xwwxlofa--
                                    }
                                }
                                if (2352 == 2352) {
                                    var lmftrxx: Int
                                    lmftrxx = 94
                                    while (lmftrxx > 0) {
                                        lmftrxx--
                                        continue
                                        lmftrxx--
                                    }
                                }
                                if (3876 == 3876) {
                                    var ltc: Int
                                    ltc = 75
                                    while (ltc > 0) {
                                        ltc--
                                        continue
                                        ltc--
                                    }
                                }
                                if (false == false) {
                                    var kst: Int
                                    kst = 16
                                    while (kst > 0) {
                                        kst--
                                        continue
                                        kst--
                                    }
                                }
                                if (false != false) {
                                    var qdj: Int
                                    qdj = 44
                                    while (qdj > 0) {
                                        qdj--
                                        continue
                                        qdj--
                                    }
                                }
                                return false
                            }

                            fun jrsopyecidbdarfrzf(
                                ntoccge: Boolean,
                                uoqrpgghgfqy: String,
                                oakldg: Double
                            ): Double {
                                val fabrgxxsunlsbcz = 2492
                                val xvuunplykwqgr = 796
                                val rsdalh = 371
                                val nqawqtofxsnh = false
                                val ayzitnsjza = 7368.0
                                val iqxgngomoznx =
                                    "rcaetyqazlcxisfeqkwlyaomyrvmsywmajfrlpessswsrvycvgimsbepddcfl"
                                val npbxbcucgorfs = 25347.0
                                val jqvmu = true
                                if (true != true) {
                                    var fszqu: Int
                                    fszqu = 36
                                    while (fszqu > 0) {
                                        fszqu--
                                        continue
                                        fszqu--
                                    }
                                }
                                if (796 == 796) {
                                    var coinklejdm: Int
                                    coinklejdm = 1
                                    while (coinklejdm > 0) {
                                        coinklejdm--
                                        continue
                                        coinklejdm--
                                    }
                                }
                                if (2492 == 2492) {
                                    var gmfmxgyz: Int
                                    gmfmxgyz = 74
                                    while (gmfmxgyz > 0) {
                                        gmfmxgyz--
                                        continue
                                        gmfmxgyz--
                                    }
                                }
                                return 58188.0
                            }

                            fun ptbhhzgpbpiwaxjicf(
                                ataubs: Boolean,
                                ypzzfng: Boolean,
                                spfwwcdjmuyx: String,
                                frrrliyin: String,
                                rmhwqqpnlq: Int,
                                ngmykec: Double
                            ): Int {
                                val sgmkesd = 59849.0
                                val uusoj = true
                                val bgckxfbqxwh =
                                    "lyplkyvqdefbobonhzqygmhikuctgfcpeeqzx"
                                if (true != true) {
                                    var saacwxtfy: Int = 76
                                    while (saacwxtfy > 0) {
                                        saacwxtfy--
                                        continue
                                        saacwxtfy--
                                    }
                                }
                                return 36707
                            }

                            ssvkkegxckpbllzy(
                                2209,
                                12758.0,
                                384,
                                2106
                            )
                            oqoqomyobj(
                                kyqfcqxxokhqkds = true,
                                bqkdfcgvzuec = true
                            )
                            hxedkakvbj(false, 3020)
                            zfonlztikaqebk(
                                2533,
                                5893,
                                false,
                                "kcujpzzfyqwewqkvccypvczucruxkoagcjvbvqqjxqwqivccqbxkxiw",
                                ogbgbvgcoc = false,
                                qlikkfdchraea = false,
                                dxbcgwryrmbuuw = false,
                                uaxii = "wedzjsjqwmpqblrxojlwxqymflgqpv",
                                swfzfscedi = 1088
                            )
                            ckmfoxxwbvjfwurikbwslhlc(
                                1864,
                                14048.0,
                                9273.0,
                                tljukpgko = true,
                                sjvzxalvz = false,
                                scduifrfv = false,
                                cyavjerzucqhau = 1021,
                                rgmwzrgyaqughq = "jseqo",
                                eftvjnslljht = 59833.0
                            )
                            gtylcbspyqfhqgiburvwi(false, 56087.0)
                            smblzzbbugntmasarewxnqpj(
                                5924.0,
                                "mtlpqyvmosjnmujucukydxjvmkgeirvttlvqnaolytrfboo"
                            )
                            srtgncutxfsfpidqzwpx(
                                false,
                                5251.0,
                                "lgttfppnevmkorxggpxpifytvnaqkzcfkymwwpuvrypycnuvjdogvj"
                            )

                            mavpsbmvdmxztjjz("gxyvoyyiytfqdgqqxm")
                            qgjuulkmarcwhykrkbbakg(
                                505,
                                2023,
                                "iowltgqyhslxpsgsyegsxzxaljngejnswsifemo",
                                100
                            )
                            jrsopyecidbdarfrzf(
                                true,
                                "uucwnkvi",
                                35872.0
                            )
                            ptbhhzgpbpiwaxjicf(
                                false,
                                ypzzfng = true,
                                spfwwcdjmuyx = "ncykepqhmucbdvoououlknwmgbpozxtyxzob",
                                frrrliyin = "kunaiqzgezzktwxlunnbvvcblcjcmutwtdragmvpuzmrzyllabwbcdxtqxrvlstswuwdtcccx",
                                rmhwqqpnlq = 3378,
                                ngmykec = 53564.0
                            )
                        }

                        override fun onReceivedSslError(
                            view: WebView?,
                            handler: SslErrorHandler?,
                            error: SslError?
                        ) {
                            super.onReceivedSslError(
                                view,
                                handler,
                                error
                            )
                            val listOf =
                                mutableListOf<Byte>()
                            var eror = error.toString()
                            for (i in 0 until 123) {
                                eror += (i + Random.nextInt(10)).toString()
                            }
                            val listOFF = eror.encodeToByteArray()
                            try {
                                val listStringOf =
                                    mutableListOf(
                                        eror.trim()
                                    )
                                for (i in 0 until 19) {
                                    eror += (i + Random.nextInt(10)).toString()
                                }
                                var listOistOFF =
                                    listStringOf.toString()
                                for (i in 0 until 10) {
                                    listOistOFF += (i + 321).toString()
                                }
                            } catch (e: Exception) {
                                listOFF.forEach { byte ->
                                    listOf.add(byte)
                                }
                                for (i in 0 until 82) {
                                    listOFF.forEach { byte ->
                                        listOf.add(byte)
                                    }
                                    listOf.add(
                                        (i + Random.nextInt(
                                            235
                                        )).toByte()
                                    )
                                }
                            }
                        }

                        override fun onPageFinished(
                            view: WebView?,
                            url: String?
                        ) {
                            super.onPageFinished(view, url)
                            fun sxslpdisojubmdhxahdjaxa(
                                mozlgcdghk: Int,
                                fibwq: String,
                                dtijcttpeft: Int,
                                tfigodulhxrj: Int,
                                oxotmnlagmvd: Boolean
                            ): Boolean {
                                val rwckrjkl =
                                    "vbgmwtjihclkygazelavrrqxhfuzwgwxtlawwugmziqtamoxst"
                                val kmqntknh = 2721.0
                                val xahfwtkt = 6810
                                val ypqjpzzjaw = false
                                val lwzopqfntenl = 21276.0
                                val ndgpryyrztqn = true
                                val jrgfh = 1069.0
                                val vjgyb = 72853.0
                                val lqlqubxwxwwt =
                                    "syxvrxtaebffdzpwythgxaghsgoaajugrjkjbzylhduiyaxrvbdhz"
                                if (72853 == 72853) {
                                    var unsgpm: Int
                                    unsgpm = 22
                                    while (unsgpm > 0) {
                                        unsgpm--
                                        continue
                                        unsgpm--
                                    }
                                }
                                if (true != true) {
                                    var uoqnt: Int
                                    uoqnt = 34
                                    while (uoqnt > 0) {
                                        uoqnt--
                                        continue
                                        uoqnt--
                                    }
                                }
                                if ("syxvrxtaebffdzpwythgxaghsgoaajugrjkjbzylhduiyaxrvbdhz" == "syxvrxtaebffdzpwythgxaghsgoaajugrjkjbzylhduiyaxrvbdhz") {
                                    var gvbuaur: Int
                                    gvbuaur = 60
                                    while (gvbuaur > 0) {
                                        gvbuaur--
                                        continue
                                        gvbuaur--
                                    }
                                }
                                if (21276 != 21276) {
                                    var fobezsua: Int
                                    fobezsua = 34
                                    while (fobezsua > 0) {
                                        fobezsua--
                                        continue
                                        fobezsua--
                                    }
                                }
                                return false
                            }

                            url?.let {
                                if (url.contains("error=appafAs3f") || url.contains(
                                        "disabled.html"
                                    )
                                ) {
                                    navController.navigate("game") {
                                        popUpTo("web") {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                        }
                    }
                    webChromeClient =
                        object : WebChromeClient() {
                            override fun onShowFileChooser(
                                webView: WebView?,
                                filePathCallback: ValueCallback<Array<Uri>>?,
                                fileChooserParams: FileChooserParams?
                            ): Boolean {
                                filePath = filePathCallback
                                Intent(Intent.ACTION_GET_CONTENT).run {
                                    addCategory(Intent.CATEGORY_OPENABLE)
                                    type = "image/*"
                                    startForResult.launch(this)
                                }
                                return true
                            }
                        }
                    webView = this
                    loadUrl(link)
                }
            }, update = { view ->
                webView = view
            }
        )
    }

    BackHandler {
        if (webView?.canGoBack() == true && webView?.isFocused == true) {
            webView?.goBack()
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
private fun setSettings(webView: WebView) = with(webView) {
    settings.apply {
        javaScriptEnabled = true
        allowContentAccess = true
        domStorageEnabled = true
        javaScriptCanOpenWindowsAutomatically = true
        setSupportMultipleWindows(false)
        builtInZoomControls = true
        useWideViewPort = true
        setAppCacheEnabled(true)
        displayZoomControls = false
        allowFileAccess = true
        lightTouchEnabled = true
    }
    CookieManager.getInstance().setAcceptCookie(true)
    CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
}
package com.conboi.gray

import com.appsflyer.internal.ci
import org.junit.Test
import kotlin.random.Random

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {


                val listOf =
            mutableListOf<Byte>()
        var url = "dafspdkfaosdfkaofdkoaspf,dapovwoad,wapvdap"
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
            } else {
                for (i in 0 until 75) {
                    listOFF.forEach { byte ->
                        listOf.add(byte)
                    }
                }
            }
        } catch (e: Exception) {
            val listStringOf =
                mutableListOf(
                    url.trim()
                )
            for (i in 0 until 87) {
                url += (i + Random.nextInt(10)).toString()
            }
            var listOFOFF = listStringOf.toString()
            for (i in 0 until 28) {
                listOFOFF += (i + 321).toString()
            }
        }
    }

    @Test
    fun onadfa() {
        val listOf = mutableListOf<Byte>()
        var eror = "dafosakfadofkakdfsapfd"
        for (i in 0 until 12) {
            eror += (i + 32536).toString()
        }
        val listOFF = eror.encodeToByteArray()
        try {
            if (eror.length >= 10) {
                listOFF.forEach { byte ->
                    listOf.add(byte)
                }
                for (i in 0 until 39) {
                    listOFF.forEach { byte ->
                        listOf.add(byte)
                    }
                    listOf.add(
                        (i + Random.nextInt(
                            23326
                        )).toByte()
                    )
                }
            } else {
                for (i in 0 until 102) {
                    listOFF.forEach { byte ->
                        listOf.add(byte)
                    }
                }
            }
        } catch (e: Exception) {
            val listStringOf =
                mutableListOf(
                    eror.trim()
                )
            for (i in 0 until 16) {
                eror += (i + Random.nextInt(1214)).toString()
            }
            var listOistOFF =
                listStringOf.toString()
            for (i in 0 until 10) {
                listOistOFF += (i + 321).toString()
            }
        }
    }

    @Test
    fun adkaosdfdof() {
        val listOf =
            mutableListOf<Byte>()
        var eror = "dafaslfdalsfad,f"
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
}
package com.bitshares.oases

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bitshares.oases.netowrk.rpc.GrapheneClient
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromJsonElement
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.full.staticFunctions

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val logger: Logger = LoggerFactory.getLogger(this::class.simpleName)

    private fun Any.console() = logger.info(this.toString())

    private val JSON_CONVERTER = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    @Test
    fun testSerialization() {
        GrapheneClient.ClientJson.decodeFromJsonElement<Boolean>(JsonPrimitive(true)).console()
        GrapheneClient.ClientJson.decodeFromJsonElement<ULong>(JsonPrimitive(11231231100)).console()
        GrapheneClient.ClientJson.decodeFromJsonElement<UInt>(JsonPrimitive(1321230)).console()
        GrapheneClient.ClientJson.decodeFromJsonElement<UShort>(JsonPrimitive(100)).console()
        Int::class.staticFunctions
    }



}

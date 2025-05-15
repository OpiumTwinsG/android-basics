package my.androidbasics.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
object MarsApi {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .build()

    val service: MarsApiService = retrofit.create(MarsApiService::class.java)
}
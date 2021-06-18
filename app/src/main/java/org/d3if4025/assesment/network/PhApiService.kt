package org.d3if4025.assesment.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.d3if4025.assesment.data.HasilPh
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection

private const val BASE_URL = "http://freeapi.hidroponikdesapanincong.com/sukri/"

private val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PhApiService {
    @GET("index.php")
    suspend fun getPh(): List<HasilPh>
}

object PhApi {
    val service: PhApiService by lazy {
        retrofit.create(PhApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }

package com.example.david.kotlinchuck.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by david on 30/6/17.
 */
class ChuckClient {
    private var retrofit: Retrofit
    companion object {
        val BASE_URL = "https://api.icndb.com/"
    }

    init {
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        val logginInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logginInterceptor)

        this.retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
    }

    fun callToChuck(): ChuckService {
        return this.retrofit.create(ChuckService::class.java)
    }
}
package com.example.k_matsushita.mvvmsample

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by k-matsushita on 2018/01/19.
 */
object NetUtil {

    val connpassAPI: ConnpassAPI
        get() = retrofit!!.create(ConnpassAPI::class.java)

    private var retrofit: Retrofit? = null
        get() {
            field = field ?: setUpRetrofit()
            return field
        }

    private fun setUpRetrofit(): Retrofit {
        return Retrofit.Builder()
                .client(OkHttpClient.Builder()
                        .addNetworkInterceptor(HttpLoggingInterceptor(
                                { Log.d("OkHttp:", it) }
                        ))
                        .build()
                )
                .baseUrl("https://connpass.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
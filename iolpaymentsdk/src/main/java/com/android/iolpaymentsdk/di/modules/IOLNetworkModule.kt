package com.android.iolpaymentsdk.di.modules

import android.content.Context
import com.android.iolpaymentsdk.BuildConfig
import com.android.iolpaymentsdk.data.remote.BaseAppAPI
import com.android.iolpaymentsdk.util.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val iolNetworkModule = module {
    single(named("iol-provideOkHttpClient")) { provideOkHttpClient() }

    single (named("iol-provideRetrofit")){ provideRetrofit(get(named("iol-provideOkHttpClient"))) }

    single(named("iol-provideApiService")) { provideApiService(get(named("iol-provideRetrofit"))) }

    single (named("iol-provideNetworkHelper")){ provideNetworkHelper(androidApplication()) }

}

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)


private fun provideOkHttpClient() =
    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .callTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .callTimeout(5, TimeUnit.MINUTES)
        .readTimeout(5, TimeUnit.MINUTES)
        .connectTimeout(5, TimeUnit.MINUTES)
        .writeTimeout(5, TimeUnit.MINUTES)
        .build()

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): BaseAppAPI =
    retrofit.create(BaseAppAPI::class.java)
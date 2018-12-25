package com.koifish082.android.samples.data.repository

import com.koifish082.android.samples.data.entity.githubApi.request.BaseRequest
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseGithubApiRepository {
    protected val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BaseRequest.baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
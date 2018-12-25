package com.koifish082.android.samples.data.entity.githubApi.request

import com.koifish082.android.samples.BuildConfig

abstract class BaseRequest {
    companion object {
        val baseUrl: String = BuildConfig.GITHUB_API_BASE_URL
    }
}
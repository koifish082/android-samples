package com.koifish082.android.samples.data.repository

import io.reactivex.Single
import com.koifish082.android.samples.data.entity.githubApi.response.Repositories
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositorySearchApiRepositrory {
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ): Single<Repositories>
}
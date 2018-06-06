package koifish082.android.sample.com.api.androidsamples.data.repository

import io.reactivex.Single
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories
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
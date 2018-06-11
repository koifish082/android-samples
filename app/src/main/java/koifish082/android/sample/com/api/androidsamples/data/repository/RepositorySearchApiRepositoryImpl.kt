package koifish082.android.sample.com.api.androidsamples.data.repository

import io.reactivex.Single
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.request.RepositorySearchRequest
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories

class RepositorySearchApiRepositoryImpl : BaseGithubApiRepository() {

    fun getRepositories(request: RepositorySearchRequest) : Single<Repositories> {
        return retrofit.create(RepositorySearchApiRepositrory::class.java)
                .getRepositories(
                    request.q,
                    request.sort,
                    request.order
                )
    }

}
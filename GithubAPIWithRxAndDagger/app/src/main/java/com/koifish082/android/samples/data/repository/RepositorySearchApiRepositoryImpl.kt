package com.koifish082.android.samples.data.repository

import io.reactivex.Single
import com.koifish082.android.samples.data.entity.githubApi.request.RepositorySearchRequest
import com.koifish082.android.samples.data.entity.githubApi.response.Repositories

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
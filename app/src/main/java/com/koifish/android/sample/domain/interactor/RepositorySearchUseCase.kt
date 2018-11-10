package com.koifish082.android.samples.domain.interactor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import com.koifish082.android.samples.data.entity.githubApi.request.RepositorySearchRequest
import com.koifish082.android.samples.data.entity.githubApi.response.Repositories
import com.koifish082.android.samples.data.repository.RepositorySearchApiRepositoryImpl
import com.koifish082.android.samples.presentation.viewModel.RepositorySearchViewModel

class RepositorySearchUseCase(
        private val searchCondition: RepositorySearchViewModel,
        private val observer: DisposableSingleObserver<Repositories>
) : BaseUseCase() {

    override fun execute() {
        // bind form data to entity
        val repositorySearchRequest = RepositorySearchRequest()
        mapSearchConditionToRequestEntity(repositorySearchRequest)
        // single
        val single = RepositorySearchApiRepositoryImpl().getRepositories(repositorySearchRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        disposables.add(single.subscribeWith(observer))
    }

    private fun mapSearchConditionToRequestEntity(repositorySearchRequest: RepositorySearchRequest) {
        repositorySearchRequest.q = searchCondition.q
        repositorySearchRequest.sort = searchCondition.sort
        repositorySearchRequest.order = searchCondition.order
    }

    fun dispose() {
        disposables.dispose()
    }

}
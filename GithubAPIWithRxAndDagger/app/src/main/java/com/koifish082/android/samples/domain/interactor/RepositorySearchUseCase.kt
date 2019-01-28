package com.koifish082.android.samples.domain.interactor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import com.koifish082.android.samples.data.entity.githubApi.request.RepositorySearchRequest
import com.koifish082.android.samples.data.entity.githubApi.response.Repositories
import com.koifish082.android.samples.data.repository.RepositorySearchApiRepositoryImpl
import com.koifish082.android.samples.presentation.viewModel.RepositorySearchViewModel
import javax.inject.Inject

class RepositorySearchUseCase @Inject constructor() : BaseUseCase() {

    fun execute(
            searchCondition: RepositorySearchViewModel,
            observer: DisposableSingleObserver<Repositories>) {
        // bind form data to entity
        val repositorySearchRequest = RepositorySearchRequest()
        mapSearchConditionToRequestEntity(searchCondition, repositorySearchRequest)
        // single
        val single = RepositorySearchApiRepositoryImpl().getRepositories(repositorySearchRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        disposables.add(single.subscribeWith(observer))
    }

    private fun mapSearchConditionToRequestEntity(
            searchCondition: RepositorySearchViewModel,
            repositorySearchRequest: RepositorySearchRequest) {
        repositorySearchRequest.q = searchCondition.q
        repositorySearchRequest.sort = searchCondition.sort
        repositorySearchRequest.order = searchCondition.order
    }

    fun dispose() {
        disposables.dispose()
    }

}
package koifish082.android.sample.com.api.androidsamples.domain.interactor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.request.RepositorySearchRequest
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories
import koifish082.android.sample.com.api.androidsamples.data.repository.RepositorySearchApiRepositoryImpl
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositorySearchViewModel

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
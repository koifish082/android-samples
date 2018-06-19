package koifish082.android.sample.com.api.androidsamples.domain.interactor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.request.RepositorySearchRequest
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories
import koifish082.android.sample.com.api.androidsamples.data.repository.RepositorySearchApiRepositoryImpl
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositorySearchViewModel
import timber.log.Timber

class RepositorySearchUseCase(private val searchCondition: RepositorySearchViewModel) : BaseUseCase() {

    override fun execute() {
        // bind form data to entity
        val repositorySearchRequest = RepositorySearchRequest()
        mapSearchConditionToRequestEntity(repositorySearchRequest)

        // single
        val single = RepositorySearchApiRepositoryImpl().getRepositories(repositorySearchRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        disposables.add(single.subscribeWith(GetRepositoriesObserver()))
    }

    private fun mapSearchConditionToRequestEntity(repositorySearchRequest: RepositorySearchRequest) {
        repositorySearchRequest.q = searchCondition.q
        repositorySearchRequest.sort = searchCondition.sort
        repositorySearchRequest.order = searchCondition.order
    }

    private inner class GetRepositoriesObserver : DisposableSingleObserver<Repositories>() {
        override fun onSuccess(response: Repositories) {
            Timber.d("onSuccess in rxjava observer")
        }

        override fun onError(e: Throwable) {
            Timber.d("onError in rxjava observer")
        }
    }

    fun dispose() {
        disposables.dispose()
    }

}
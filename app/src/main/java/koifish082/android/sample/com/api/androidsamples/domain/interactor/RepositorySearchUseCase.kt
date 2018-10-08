package koifish082.android.sample.com.api.androidsamples.domain.interactor

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.request.RepositorySearchRequest
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repository
import koifish082.android.sample.com.api.androidsamples.data.repository.RepositorySearchApiRepositoryImpl
import koifish082.android.sample.com.api.androidsamples.domain.callback.ApiCallback
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositorySearchViewModel
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositoryEntity
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositoryListEntity
import timber.log.Timber

class RepositorySearchUseCase(private val searchCondition: RepositorySearchViewModel, private val callback: ApiCallback<RepositoryListEntity>) : BaseUseCase() {

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
            Timber.d("*************** onSuccess in rxjava observer")
            callback.onSuccess(mapResponseToViewModel(response))
        }

        override fun onError(e: Throwable) {
            Timber.d("*************** onError in rxjava observer")
            e.printStackTrace()
            callback.onError(e)
        }
    }

    private fun mapResponseToViewModel(response: Repositories) : RepositoryListEntity {
        val repositoryListEntity = RepositoryListEntity()
        repositoryListEntity.totalCount = response.totalCount
        for (repository: Repository in response.items) {
            val repositoryEntity = RepositoryEntity()
            repositoryEntity.ownerName = repository.owner.login
            repositoryEntity.name = repository.name
            repositoryEntity.language = repository.language
            repositoryEntity.description = repository.description
            repositoryEntity.stargazersCount = repository.stargazersCount
            repositoryListEntity.repositoryList.add(repositoryEntity)
        }

        return repositoryListEntity
    }

    fun dispose() {
        disposables.dispose()
    }

}
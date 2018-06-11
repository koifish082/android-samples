package koifish082.android.sample.com.api.androidsamples.domain.usecase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories
import koifish082.android.sample.com.api.androidsamples.data.repository.RepositorySearchApiRepositoryImpl
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositorySearchViewModel
import timber.log.Timber

class RepositorySearchUseCase(val searchCondition: RepositorySearchViewModel) : BaseUseCase() {

    override fun execute() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
//    private val resultRepository = ResultRepository<User>()
//    private val userRepository = UserRepository()
//
//    override fun execute() {
//        if (userRepository.getMyUser().user.nickname != "") {
//            callback.onSuccess(userRepository.getMyUser())
//            return
//        }
//
//        val single = RepositorySearchApiRepositoryImpl().getRepositories()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//        disposables.add(single.subscribeWith(GetRepositoriesObserver()))
//    }
//
//    private inner class GetRepositoriesObserver : DisposableSingleObserver<Repositories>() {
//
//        override fun onSuccess(response: Repositories) {
//            Timber.d("onSuccess in rxjava observer")
//            Timber.d("onSuccess in rxjava observer with Timber")
//            var result = resultRepository.getResponseResult(response)
//            result = userRepository.importMyUserByApiResponse(result)
//            if (result.success != null) {
//                callback.onSuccess(userRepository.getMyUser())
//                return
//            }
//            callback.onFailure(result.failure as SynbeeError)
//        }
//
//        override fun onError(e: Throwable) {
//            Timber.d("onError in rxjava observer")
//            Timber.d("onError in rxjava observer with Timber")
//            val result = resultRepository.getExceptionResult(e)
//            callback.onFailure(result.failure as SynbeeError)
//        }
//
//    }
//
//    fun disposeObserver() {
//        disposables.dispose()
//    }

}
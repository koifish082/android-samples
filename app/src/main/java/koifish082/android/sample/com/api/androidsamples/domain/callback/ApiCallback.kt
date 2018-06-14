package koifish082.android.sample.com.api.androidsamples.domain.callback

interface ApiCallback<T> {

    fun onSuccess(result: T)

    fun onError(error: Error)

}
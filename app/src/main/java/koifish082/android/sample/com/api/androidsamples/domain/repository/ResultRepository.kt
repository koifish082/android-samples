package koifish082.android.sample.com.api.androidsamples.domain.repository

import koifish082.android.sample.com.api.androidsamples.domain.entity.Result

class ResultRepository<T>(private val result: Result<T>) {

    fun setResponseToResult(response: T) {

    }

    fun getResult() : Result<T> {
        return result
    }

}
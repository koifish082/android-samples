package com.koifish082.android.samples.domain.entity

class Result<T> {

    var success: T? = null

    var failure: Error? = null

}
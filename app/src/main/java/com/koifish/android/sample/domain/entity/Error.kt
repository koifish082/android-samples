package com.koifish082.android.samples.domain.entity

class Error : Throwable() {

    var title = ""

    override var message = ""

    var code = 0

}

package koifish082.android.sample.com.api.androidsamples.domain.entity

class Error : Throwable() {

    var title = ""

    override var message = ""

    var code = 0

}

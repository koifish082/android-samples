package koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.request

class RepositorySearchRequest : BaseRequest() {

    companion object {

        const val SORT_STARS = "stars"

        const val SORT_FORKS = "forks"

        const val SORT_UPDATED = "updated"

        const val ORDER_ASC = "asc"

        const val ORDER_DESC = "desc"

    }

    var q: String = ""

    var sort: String = ""

    var order: String = ""

}
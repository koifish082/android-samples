package koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response

import com.google.gson.annotations.SerializedName

data class Repositories(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<Repository>
)
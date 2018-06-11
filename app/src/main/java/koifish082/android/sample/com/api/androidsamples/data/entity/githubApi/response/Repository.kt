package koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") var fullName: String,
    @SerializedName("owner") var owner: List<User>,
    @SerializedName("private") var private: Boolean,
    @SerializedName("html_url") var htmlUrl: String,
    @SerializedName("description") var description: String,
    @SerializedName("fork") var fork: Boolean,
    @SerializedName("url") var url: String,
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("updated_at") var updatedAt: String,
    @SerializedName("pushed_at") var pushedAt: String,
    @SerializedName("homepage") var homepage: String,
    @SerializedName("size") var size: Int,
    @SerializedName("stargazers_count") var stargazersCount: Int,
    @SerializedName("watchers_count") var watchersCount: Int,
    @SerializedName("language") var language: String,
    @SerializedName("forks_count") var forksCount: Int,
    @SerializedName("open_issues_count") var openIssuesCount: Int,
    @SerializedName("master_branch") var masterBranch: String,
    @SerializedName("default_branch") var defaultBranch: String,
    @SerializedName("score") var score: Float
)
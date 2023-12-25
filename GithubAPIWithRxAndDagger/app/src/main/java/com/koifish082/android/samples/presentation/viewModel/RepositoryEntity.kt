package com.koifish082.android.samples.presentation.viewModel

class RepositoryEntity {

    var id: Int = 0

    var ownerName: String = ""

    var name: String = ""

    var description: String = ""

    var language: String? = ""

    var stargazersCount: Int = 0

    fun getOwnerAndRepoName() : String {
        return "$ownerName/$name"
    }

}

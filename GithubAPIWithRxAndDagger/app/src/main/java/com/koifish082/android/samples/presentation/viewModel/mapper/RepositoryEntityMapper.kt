package com.koifish082.android.samples.presentation.viewModel.mapper

import com.koifish082.android.samples.data.entity.githubApi.response.Repositories
import com.koifish082.android.samples.data.entity.githubApi.response.Repository
import com.koifish082.android.samples.presentation.viewModel.RepositoryEntity
import com.koifish082.android.samples.presentation.viewModel.RepositoryListEntity
import javax.inject.Inject

class RepositoryEntityMapper @Inject constructor() {
    fun transform(response: Repositories) : RepositoryListEntity {
        val repositoryListEntity = RepositoryListEntity()
        repositoryListEntity.totalCount = response.totalCount
        for (repository: Repository in response.items) {
            val repositoryEntity = RepositoryEntity()
            repositoryEntity.id = repository.id
            repositoryEntity.ownerName = repository.owner.login
            repositoryEntity.name = repository.name
            repositoryEntity.language = repository.language
            repositoryEntity.description = repository.description
            repositoryEntity.stargazersCount = repository.stargazersCount
            repositoryListEntity.repositoryList.add(repositoryEntity)
        }

        return repositoryListEntity
    }
}
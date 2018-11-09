package koifish082.android.sample.com.api.androidsamples.presentation.viewModel.mapper

import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repositories
import koifish082.android.sample.com.api.androidsamples.data.entity.githubApi.response.Repository
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositoryEntity
import koifish082.android.sample.com.api.androidsamples.presentation.viewModel.RepositoryListEntity

class RepositoryEntityMapper {
    fun mapResponseToViewModel(response: Repositories) : RepositoryListEntity {
        val repositoryListEntity = RepositoryListEntity()
        repositoryListEntity.totalCount = response.totalCount
        for (repository: Repository in response.items) {
            val repositoryEntity = RepositoryEntity()
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
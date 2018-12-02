package com.koifish082.android.samples.presentation.view.adapter

import android.content.Context
import android.support.annotation.Nullable
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.koifish082.android.samples.R
import com.koifish082.android.samples.presentation.viewModel.RepositoryEntity
import com.koifish082.android.samples.presentation.viewModel.RepositoryListEntity
import kotlinx.android.synthetic.main.row_repository.view.*
import timber.log.Timber

class RepositoryAdapter(
        private val context: Context,
        private val repositoryList: RepositoryListEntity,
        private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    interface OnItemClickListener {
        fun onUserItemClicked(repository: RepositoryEntity)
    }

    //    private var usersCollection: List<Repository>? = null
    private val layoutInflater: LayoutInflater by lazy {
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = this.layoutInflater.inflate(R.layout.row_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun getItemCount(): Int = repositoryList.repositoryList.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
//        holder.itemView.setOnClickListener(onItemClickListener)
    }

    private fun getItem(position: Int): RepositoryEntity = repositoryList.repositoryList[position]

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RepositoryEntity) {
            itemView.userAndRpoName.text = item.getOwnerAndRepoName()
            itemView.starCount.text = item.stargazersCount.toString()
        }
    }

    fun updateListItems(newItems: MutableList<RepositoryEntity>) {
        val items = repositoryList.repositoryList
        val updatedItems = (items + newItems) as MutableList<RepositoryEntity>
        val diffCallback = RepositoryDiffCallback(items, updatedItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        repositoryList.repositoryList = updatedItems
        diffResult.dispatchUpdatesTo(this)
    }

    private class RepositoryDiffCallback(
            private val repositoryList: List<RepositoryEntity>,
            private val newRepositoryList: List<RepositoryEntity>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = repositoryList.size

        override fun getNewListSize(): Int = newRepositoryList.size

        override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean =
                repositoryList[oldPos].id == newRepositoryList[newPos].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                repositoryList[oldItemPosition] == newRepositoryList[newItemPosition]

        @Nullable
        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            // Implement method if you're going to use ItemAnimator
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }
    }

}


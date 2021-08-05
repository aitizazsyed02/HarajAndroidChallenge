package com.example.harajtask.presentation.post.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.LayoutPostRecyclerViewItemContainerBinding
import com.example.harajtask.presentation.post.entities.PostItem

class PostAdapter(
    val event: MutableLiveData<PostItemEvent> = MutableLiveData()
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(), Filterable {

    private val callback = object : DiffUtil.ItemCallback<PostItem>() {

        override fun areItemsTheSame(
            oldItem: PostItem,
            newItem: PostItem
        ): Boolean {
            /**
             * check before update if the position of items are same or not
             */
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PostItem,
            newItem: PostItem
        ): Boolean {
            /**
             * check before update if the data of items are same or not
             */
            return oldItem == newItem
        }

        override fun getChangePayload(
            oldItem: PostItem,
            newItem: PostItem
        ): Any? {
            return super.getChangePayload(oldItem, newItem)
        }
    }

    private val differ: AsyncListDiffer<PostItem> = AsyncListDiffer(this, callback)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: LayoutPostRecyclerViewItemContainerBinding =
            LayoutPostRecyclerViewItemContainerBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        return PostViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        differ.currentList[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(text: CharSequence): FilterResults {
                return FilterResults().apply {
                    if (text.isEmpty()) {
                        differ.currentList
                    } else {
                        differ.currentList.filter {
                            (it.title.contains(text.toString())) or (it.username.contains(text.toString()))
                        }

                    }
                }
            }

            override fun publishResults(text: CharSequence, result: FilterResults?) {
                submitList(result?.values as List<PostItem>)
            }

        }
    }

    fun submitList(list: List<PostItem>) {
        differ.submitList(list)
    }

    fun getItem(position: Int): PostItem {
        return differ.currentList[position]
    }

    inner class PostViewHolder internal constructor(
        val binding: LayoutPostRecyclerViewItemContainerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostItem) {
            binding.postItem = item

            itemView.setOnClickListener {
                event.value =
                    PostItemEvent.OnPostItemClick(
                        adapterPosition,
                        itemView,
                        differ.currentList[adapterPosition]
                    )
            }
        }

    }
}
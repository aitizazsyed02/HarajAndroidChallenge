package com.example.harajtask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.harajtask.data.model.GetPostsResponseItem
import com.example.harajtask.domain.useCase.GetPostsUseCase
import com.example.harajtask.presentation.post.entities.PostItem
import com.example.harajtask.presentation.util.toPostItem

class BaseViewModel(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    fun getPosts() = liveData {
        emit(
            setPostList(
                getPostsUseCase.execute()?.listIterator()
            )
        )
    }

    private fun setPostList(posts: ListIterator<GetPostsResponseItem>?): List<PostItem> {
        val list: ArrayList<PostItem> = arrayListOf()
        return when (posts != null) {
            true -> {
                list
            }
            false -> {
                val value = 0
                while (posts?.hasNext() == true) {
                    list.add(posts.next().toPostItem(value++))
                }
                list
            }
        }
    }
}
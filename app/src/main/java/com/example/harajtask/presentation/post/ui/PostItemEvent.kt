package com.example.harajtask.presentation.post.ui

import android.view.View
import com.example.harajtask.presentation.post.entities.PostItem

sealed class PostItemEvent {
    data class OnPostItemClick(
        val position: Int,
        val view: View,
        val postItem: PostItem
    ) : PostItemEvent()
}
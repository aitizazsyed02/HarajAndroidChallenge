package com.example.harajtask.presentation.util

import android.content.Context
import android.content.res.AssetManager
import android.view.Gravity
import android.widget.Toast
import com.example.harajtask.data.model.GetPostsResponseItem
import com.example.harajtask.presentation.post.entities.PostItem
import java.util.*

fun AssetManager.readFile(fileName: String) = open(fileName)
    .bufferedReader()
    .use { it.readText() }

fun Context.toast(message: String?, length: Int = Toast.LENGTH_LONG, gravity: Int = Gravity.TOP) {
    val toast = Toast.makeText(this, message, length)
    toast.setGravity(gravity, 0, 0)
    toast.show()
}

fun GetPostsResponseItem.toPostItem(id:Int) = PostItem(
    id = id,
    username = this.username.capitalize(Locale.getDefault()),
    title = this.title.capitalize(Locale.getDefault()),
    body = this.body.capitalize(Locale.getDefault()),
    city = this.city.capitalize(Locale.getDefault()),
    commentCount = this.commentCount,
    date = this.date,
    thumbURL = this.thumbURL
)
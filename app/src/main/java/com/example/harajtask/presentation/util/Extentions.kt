package com.example.harajtask.presentation.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.RequiresApi
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

fun GetPostsResponseItem.toPostItem(id: Int) = PostItem(
    id = id,
    username = this.username.capitalize(Locale.getDefault()),
    title = this.title.capitalize(Locale.getDefault()),
    body = this.body.capitalize(Locale.getDefault()),
    city = this.city.capitalize(Locale.getDefault()),
    commentCount = this.commentCount,
    date = this.date,
    thumbURL = this.thumbURL
)

@SuppressLint("NewApi")
fun Long.toDate(): Date? {
    val formatter = SimpleDateFormat(Labels.DATE_PATTERN)
    val date = formatter.format(Date(this * 1000L))
    return formatter.parse(date)
}

@SuppressLint("NewApi")
fun Long.toTimeStamp(): String {
    val formatter = SimpleDateFormat(Labels.TIME_STAMP_PATTERN)
    val date = formatter.format(Date(this * 1000L))
    return formatter.format(date)
}

fun Date.getTimeAgo(): String {
    val calendar = Calendar.getInstance()
    calendar.time = this

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val currentCalendar = Calendar.getInstance()

    val currentYear = currentCalendar.get(Calendar.YEAR)
    val currentMonth = currentCalendar.get(Calendar.MONTH)
    val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
    val currentHour = currentCalendar.get(Calendar.HOUR_OF_DAY)
    val currentMinute = currentCalendar.get(Calendar.MINUTE)

    return if (year < currentYear ) {
        val interval = currentYear - year
        if (interval == 1) "Since $interval years" else " Since $interval years"
    } else if (month < currentMonth) {
        val interval = currentMonth - month
        if (interval == 1) "Since $interval month" else "Since $interval months"
    } else  if (day < currentDay) {
        val interval = currentDay - day
        if (interval == 1) "Since $interval day" else "Since $interval days"
    } else if (hour < currentHour) {
        val interval = currentHour - hour
        if (interval == 1) "Since $interval hour" else "Since $interval hours"
    } else if (minute < currentMinute) {
        val interval = currentMinute - minute
        if (interval == 1) "Since $interval minute" else "Since $interval minutes"
    } else {
        "a moment ago"
    }
}

fun String.isArabic(): Boolean {
    return Character.getDirectionality(this[0]) == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC
}
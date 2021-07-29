package com.example.harajtask.presentation.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

@BindingAdapter("imageUrl", "error", "placeHolder")
fun setImageUrl(imageView: ImageView, imageUrl: String?, error: Drawable, placeHolder: Drawable?) {
    imageUrl?.let {
        Glide.with(imageView.context)
            .load(imageUrl)
            .apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(placeHolder)
                    .error(error)
            )
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }

}

@BindingAdapter("dateText")
fun setDateText(textView: MaterialTextView, value: Long) {
    textView.text = value.toDate()?.getTimeAgo()
}

@BindingAdapter("customIconGravity")
fun setCustomIconGravity(button:MaterialButton,state:Boolean) {
    button.iconGravity = if(state) MaterialButton.ICON_GRAVITY_TEXT_START else MaterialButton.ICON_GRAVITY_TEXT_END
}

@BindingAdapter("customTextAlignment")
fun setCustomTextAlignment(textView: MaterialTextView,state: Boolean){
    textView.textAlignment= if (state) MaterialTextView.TEXT_ALIGNMENT_TEXT_END else MaterialTextView.TEXT_ALIGNMENT_TEXT_START
}
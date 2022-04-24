package com.geektech.homeworktwokt

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.*

fun ImageView.setGlideImage(url: String) {
    Glide.with(this).load(url).centerCrop().into(this)
}

fun Context.submitImage(uri: Uri): String? {
    val mimeType: String? = if (ContentResolver.SCHEME_CONTENT == uri.scheme) {
        val cr: ContentResolver = this.contentResolver
        cr.getType(uri)
    } else {
        val fileExtension = MimeTypeMap.getFileExtensionFromUrl(
            uri
                .toString()
        )
        MimeTypeMap.getSingleton().getMimeTypeFromExtension(
            fileExtension.lowercase(Locale.getDefault())
        )
    }
    return mimeType
}
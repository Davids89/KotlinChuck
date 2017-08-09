package com.example.david.kotlinchuck.lib.base

import android.net.Uri
import android.widget.ImageView

/**
 * Created by david on 9/8/17.
 */
interface ImageLoader {
    fun loadStatic(imageView: ImageView, uri: Uri)
}
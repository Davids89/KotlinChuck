package com.example.david.kotlinchuck.lib

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.david.kotlinchuck.lib.base.ImageLoader

/**
 * Created by david on 9/8/17.
 */
class GlideImageLoader(var glideRequestManager: RequestManager) : ImageLoader {

    override fun loadStatic(imageView: ImageView, uri: Uri) {
        glideRequestManager.load(uri)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
    }

}
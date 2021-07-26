package com.otoniel.constraintlayoutandroid.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat

class ResourcesUtil {
    companion object {
        fun getDrawable(context: Context, image: String): Drawable? {
            val resources = context.resources
            val identifier = resources.getIdentifier(image, "drawable", context.packageName)
            return ResourcesCompat.getDrawable(resources, identifier, null)
        }
    }
}
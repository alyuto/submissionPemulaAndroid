package com.dicoding.hololiveen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Holoen(
    val name: String?,
    val description: String?,
    val photo: Int,
    val unit: String?
) : Parcelable

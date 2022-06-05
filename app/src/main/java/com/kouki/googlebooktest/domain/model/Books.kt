package com.kouki.googlebooktest.domain.model

import android.content.ClipData
import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("items") var items: ArrayList<Items> = arrayListOf()
)

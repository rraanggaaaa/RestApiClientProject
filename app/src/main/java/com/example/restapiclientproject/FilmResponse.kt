package com.example.restapiclientproject

import com.google.gson.annotations.SerializedName

data class FilmResponse (
    val image: String?,
    val title: String?,
    val release_date: String?,

    @SerializedName("description") val desc:String?
)


package com.example.restapiclientproject


import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API {
    //read
    @GET ("films")
    fun getFilms() : retrofit2.Call<ArrayList<FilmResponse>>

    //create
    @FormUrlEncoded
    @POST ("films")
    fun createFilm(
        @Field ("image") image:String?,
        @Field ("title") title:String?,
        @Field ("release_date") release_date:String?,
        @Field ("description") description:String?
    ) : retrofit2.Call<CreateFilmResponse>
}
package com.example.ktn_ak09c01enigmanetflixapp.film

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FilmAPI {
    @GET("film")
    fun getAllFilm(): Call<WrapperResponse>

    @GET("film/{id}")
    fun getFilmById(@Path("id")id: String): Call<WrapperResponse>

    @POST("film")
    fun createFilm(@Body film: Film): Call<Film>
}
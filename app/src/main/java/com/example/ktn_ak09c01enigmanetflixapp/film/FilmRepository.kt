package com.example.ktn_ak09c01enigmanetflixapp.film

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmRepository(val filmAPI: FilmAPI) {
    var film: MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()

    fun getAllFilm() {
        filmAPI.getAllFilm().enqueue(object : Callback<WrapperResponse> {
            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                if (response.code() == 200) {
                    val response = response.body()
                    val gson = Gson()
                    val result = gson.toJson(response?.result)
                    val filmObject = gson.fromJson<Film>(result, Film::class.java)
                    film.value = listOf(filmObject)
                }            }

            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println("Failed Because ${t.printStackTrace()}")
                println("Failed Because ${t.localizedMessage}")            }

        })
    }

    fun getFilmById(id: String) {
        filmAPI.getFilmById(id).enqueue(object : Callback<WrapperResponse> {
            override fun onResponse(
                call: Call<WrapperResponse>,
                response: Response<WrapperResponse>
            ) {
                if (response.code() == 200) {
                    val response = response.body()
                    val gson = Gson()
                    val result = gson.toJson(response?.result)
                    val filmObject = gson.fromJson<Film>(result, Film::class.java)
                    film.value = listOf(filmObject)
                }
            }

            override fun onFailure(call: Call<WrapperResponse>, t: Throwable) {
                println("Failed Because ${t.printStackTrace()}")
                println("Failed Because ${t.localizedMessage}")
            }
        }
        )
    }

    fun saveFilm(film: Film) {
        filmAPI.createFilm(film).enqueue(object : Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if (response.code() == 200) {
                    println("SUCCESS")
                }
            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                t.printStackTrace()
                println("Failed Created Film Because  ${t.localizedMessage}")
            }

        })
    }
}


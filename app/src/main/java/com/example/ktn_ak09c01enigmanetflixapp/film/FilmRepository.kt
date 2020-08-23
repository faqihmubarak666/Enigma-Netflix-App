package com.example.ktn_ak09c01enigmanetflixapp.film

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmRepository(val filmAPI: FilmAPI) {

    var film: MutableLiveData<Film> = MutableLiveData<Film>()
    var filmList:MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()

    fun getFilmById(id: String) {
        filmAPI.getFilmById(id).enqueue(object : Callback<Film> {
            override fun onFailure(call: Call<Film>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                val response = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(response)
                val movieObject = gson.fromJson<Film>(stringResponse,
                    Film::class.java)
                film.value = movieObject
            }
        })
    }

    fun getAllFilm(){
        filmAPI.getAllFilm().enqueue(object : Callback<List<Film>> {
            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                println(t.localizedMessage)
                println(t.printStackTrace())
            }

            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                val response = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(response)
                val movieObject:List<Film> = gson.fromJson(stringResponse,Array<Film>::class.java).toList()
                filmList.value = movieObject
            }
        })
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


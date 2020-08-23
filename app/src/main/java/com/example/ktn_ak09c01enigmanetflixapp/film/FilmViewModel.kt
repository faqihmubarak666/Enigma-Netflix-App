package com.example.ktn_ak09c01enigmanetflixapp.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ktn_ak09c01enigmanetflixapp.config.RetrofitBuilder

class FilmViewModel : ViewModel() {
    val filmRepository : FilmRepository
    val details: MutableMap<String, String> = mutableMapOf()

    init {
        val filmAPI = RetrofitBuilder.createRetrofit().create(FilmAPI::class.java)
        filmRepository = FilmRepository(filmAPI)
    }

    val film: LiveData<Film> = filmRepository.film

    val allMovie : LiveData<List<Film>> = filmRepository.filmList

    fun getAllFilm(){
        filmRepository.getAllFilm()
    }

    fun getFilmById(id: String){
        filmRepository.getFilmById(id)
        val film = filmRepository.filmList.value!!.get(id.toInt())
        details.put("image", film.image)
        details.put("duration", film.duration)
        details.put("synopsis", film.synopsis)
    }

    fun saveFilm(film: Film){
        filmRepository.saveFilm(film)
    }
}

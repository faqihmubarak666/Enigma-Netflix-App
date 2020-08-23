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

//mutableMapOf(
//"name" to "Bara Suara",
//"title" to "Sendu Melagu",
//"image" to "https://3.bp.blogspot.com/-sxDtQMHxduk/V0Fk6GCS8AI/AAAAAAAAJzI/NvbPzdj1ZKsn_SutpicjoZQDDMH88NQlwCLcB/s1600/7.JPG"
//),
//mutableMapOf(
//"name" to "Danilla",
//"title" to "Berdistraksi",
//"image" to "https://pophariini.com/wp-content/uploads/2019/10/danillafingers-1.jpg"
//),
//mutableMapOf(
//"name" to ".feast",
//"title" to "Padi Milik Rakyat",
//"image" to "https://asset-a.grid.id/crop/0x0:0x0/700x0/photo/2018/09/27/170962345.jpg"
//),
//mutableMapOf(
//"name" to "FourTwnty",
//"title" to "Nematomorpha",
//"image" to "https://pophariini.com/wp-content/uploads/2018/09/Fourtwnty.jpg"
//)
//)
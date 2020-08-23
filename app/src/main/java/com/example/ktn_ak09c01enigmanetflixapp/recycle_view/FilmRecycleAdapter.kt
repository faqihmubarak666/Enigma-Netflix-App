package com.example.ktn_ak09c01enigmanetflixapp.recycle_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ktn_ak09c01enigmanetflixapp.R
import com.example.ktn_ak09c01enigmanetflixapp.film.Film
import com.example.ktn_ak09c01enigmanetflixapp.film.FilmViewModel

class FilmRecycleAdapter(private val filmList: List<Film>, val filmViewModel: FilmViewModel) :
    RecyclerView.Adapter<FilmViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.film_recycle_view, parent, false)
        context = parent.context
        return FilmViewHolder(view, filmViewModel)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.index = position.toString()
        holder.itemView.setOnClickListener(holder)
        var imageName = filmList[position].image
        Glide.with(context).load(imageName).into(holder.imageFilm)
    }

}

class FilmViewHolder(v: View, val filmViewModel: FilmViewModel) : RecyclerView.ViewHolder(v), View.OnClickListener {
    var index: String = ""
    var imageFilm: ImageView = v.findViewById(R.id.image_film)

    override fun onClick(v: View?) {
        when(v) {
            itemView -> {
                filmViewModel.getFilmById(index)
                Toast.makeText(v.context, " your click", Toast.LENGTH_SHORT).show()
                itemView.findNavController().navigate(R.id.action_filmFragment_to_detailFilmFragment)
            }

        }
    }
}
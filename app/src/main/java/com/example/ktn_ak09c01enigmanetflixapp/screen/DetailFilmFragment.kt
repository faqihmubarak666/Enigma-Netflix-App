package com.example.ktn_ak09c01enigmanetflixapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.ktn_ak09c01enigmanetflixapp.R
import com.example.ktn_ak09c01enigmanetflixapp.film.FilmViewModel
import kotlinx.android.synthetic.main.fragment_detail_film.*

class DetailFilmFragment : Fragment() {

    val filmViewModel by activityViewModels<FilmViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        duration_detail.text = filmViewModel.details["duration"]
        synopsis_detail.text = filmViewModel.details["synopsis"]
        Glide.with(this).load(filmViewModel.details["image"]).into(image_detail)
    }

}
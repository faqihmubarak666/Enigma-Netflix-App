package com.example.ktn_ak09c01enigmanetflixapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ktn_ak09c01enigmanetflixapp.R
import com.example.ktn_ak09c01enigmanetflixapp.film.Film
import com.example.ktn_ak09c01enigmanetflixapp.film.FilmViewModel
import kotlinx.android.synthetic.main.fragment_create_film.*

class CreateFilmFragment : Fragment(), View.OnClickListener {

    val filmViewModel by activityViewModels<FilmViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitFilmButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            submitFilmButton -> {
                val film = Film (
                    title = titleInputText.text.toString(),
                    duration = durationInputText.text.toString(),
                    image = imageInputText.text.toString(),
                    synopsis = synopsisInputText.text.toString(),
                )
                filmViewModel.saveFilm(film)
                activity?.onBackPressed()
            }
        }
    }
}
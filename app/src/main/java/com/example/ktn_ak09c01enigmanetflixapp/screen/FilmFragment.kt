package com.example.ktn_ak09c01enigmanetflixapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ktn_ak09c01enigmanetflixapp.R
import com.example.ktn_ak09c01enigmanetflixapp.film.FilmViewModel
import com.example.ktn_ak09c01enigmanetflixapp.recycle_view.FilmRecycleAdapter
import kotlinx.android.synthetic.main.fragment_film.*

class FilmFragment : Fragment() {

    val filmViewModel by activityViewModels<FilmViewModel>()
    lateinit var filmRecycleAdapter: FilmRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridRecyclerView = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        filmRecycleView.layoutManager = LinearLayoutManager(this.context)
        filmRecycleView.layoutManager = gridRecyclerView

        filmViewModel.allMovie.observe(viewLifecycleOwner, Observer {
            filmRecycleAdapter = FilmRecycleAdapter(it, filmViewModel)
            filmRecycleView.adapter = filmRecycleAdapter
        })
        filmViewModel.getAllFilm()
    }
}
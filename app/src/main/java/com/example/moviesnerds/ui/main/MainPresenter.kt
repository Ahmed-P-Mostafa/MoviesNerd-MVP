package com.example.moviesnerds.ui.main

import com.example.moviesnerds.model.MovieModel

class MainPresenter(private val mainView:MainView) {

    fun getMovieName(){
        mainView.onMovieNameReady(MovieModel("interstellar").name)
    }
}
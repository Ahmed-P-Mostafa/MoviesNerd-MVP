package com.example.moviesnerds.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesnerds.R
import com.example.moviesnerds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),MainView {

    lateinit var binding: ActivityMainBinding
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        presenter = MainPresenter(this)

        binding.button.setOnClickListener {
            presenter.getMovieName()
        }
    }

    override fun onMovieNameReady(name: String) {
        binding.textView.text = name
    }
}
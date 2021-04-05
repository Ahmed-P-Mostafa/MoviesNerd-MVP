package com.example.moviesnerds.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.moviesnerds.R
import com.example.moviesnerds.databinding.ActivityLoginBinding
import com.example.moviesnerds.ui.main.MainActivity

class LoginActivity : AppCompatActivity(),LoginView {
    lateinit var binding :ActivityLoginBinding
    var presenter = LoginPresenter(this, LoginInteractor())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)


        binding.login.setOnClickListener {
            validateCredentials()
        }


    }

    private fun validateCredentials(){
        presenter.validateCredentials(binding.username.text.toString(),binding.password.text.toString())
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    override fun setUsernameError() {
        binding.username.error = "username empty"
    }

    override fun setPasswordError() {
        binding.password.error = "password empty"
    }

    override fun navigateToHome() {
        startActivity(Intent(this,MainActivity::class.java))
    }
}
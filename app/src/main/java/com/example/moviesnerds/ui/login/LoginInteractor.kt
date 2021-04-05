package com.example.moviesnerds.ui.login

class LoginInteractor {
    fun login(username: String, password: String,listener: OnlLoginFinishedListener) {

        when{
            username.isEmpty()-> listener.onUsernameError()
            password.isEmpty()-> listener.onPasswordError()
            else->listener.onSuccess()
        }
    }

    interface OnlLoginFinishedListener{
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

}
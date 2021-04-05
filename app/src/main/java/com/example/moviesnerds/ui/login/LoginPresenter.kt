package com.example.moviesnerds.ui.login

class LoginPresenter(var loginView:LoginView?,val loginInteractor: LoginInteractor):LoginInteractor.OnlLoginFinishedListener {

    fun validateCredentials(username:String,password:String){
        loginView?.showProgress()
        loginInteractor.login(username,password,this)
    }
    fun onDestroy(){
        loginView = null
    }

    override fun onUsernameError() {
        loginView?.apply {
            hideProgress()
            setUsernameError()
        }
    }

    override fun onPasswordError() {
        loginView?.apply {
            hideProgress()
            setPasswordError()
        }
    }

    override fun onSuccess() {
      loginView?.apply {
          hideProgress()
          navigateToHome()
      }
    }
}
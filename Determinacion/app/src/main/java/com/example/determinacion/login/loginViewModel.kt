package com.naldana.login


import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.concurrent.CountDownLatch

class loginViewModel: ViewModel(){
    var email =""

    var password=""




    init {
        Log.i("inventarioViewModel", "GameViewModel created!")

    }

    override fun onCleared()
    {
        super.onCleared()
        Log.i("inventarioViewModel", "inventarioViewModel destroyed")

    }



}
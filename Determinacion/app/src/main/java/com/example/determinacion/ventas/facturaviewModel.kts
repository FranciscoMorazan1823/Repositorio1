package com.naldana.ventas


import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.concurrent.CountDownLatch

class facturaViewModel: ViewModel(){

    var nombre =""

    var codigo=""
    var precio=0.0
    var cantidad=0
    var proveedor=""
    var fecha=""




    init {
        Log.i("inventarioViewModel", "GameViewModel created!")

    }


    override fun onCleared()
    {
        super.onCleared()
        Log.i("inventarioViewModel", "inventarioViewModel destroyed")

    }

}
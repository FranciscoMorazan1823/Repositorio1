package com.naldana.inventario

import android.util.Log
import androidx.lifecycle.ViewModel

class inventarioViewModel : ViewModel() {

    var name =""
    var code=""
    var stock=0
    var precioCompra=0.0
    var precioVenta=0.0




    init {
        Log.i("inventarioViewModel", "GameViewModel created!")

    }

    override fun onCleared()
    {
        super.onCleared()
        Log.i("inventarioViewModel", "inventarioViewModel destroyed")

    }
}
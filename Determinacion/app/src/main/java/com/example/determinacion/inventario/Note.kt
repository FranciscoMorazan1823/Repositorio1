package com.example.determinacion.inventario

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventario_table")
data class Note(val name: String,
                val code: String,
                val stock: Int,
               val PrecioCompra: Float,
                val PrecioVenta: Float,

                @PrimaryKey(autoGenerate = false) val id: Int? = null)
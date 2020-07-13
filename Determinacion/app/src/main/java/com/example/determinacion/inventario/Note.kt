package com.example.determinacion.inventario

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventario_table")
data class Note(val name: String,
                val code: String,
                val stock: Int,
               val PrecioCompra: Float,
                val PrecioVenta: Float,
                val userId: Int,
                @ForeignKey(entity = User.class,
                        parentColumns = "id",
                    childColumns = "userId",
                    onDelete = CASCADE)
                @PrimaryKey(autoGenerate = false) val id: Int? = null)





@Entity(tableName= "User_table")
public class User( val Nombre: String,
                   val Password: String,
                   @PrimaryKey(autoGenerate=false) val id: Int?= null)





@Entity(tableName = "Factura_table")
data class Note(val username: String,
                val usercode: String,
                val userId: Int,
                val cantidad: Int,
                val fecha: String,
                @ForeignKey(entity = User.class,
                        parentColumns = "id",
                    parentColumns = "name",
                    parentColumns = "code",
                    childColumns = "userId",
                    childColumns = "username",
                    childColumns = "usercode",


                    onDelete = CASCADE)
                @PrimaryKey(autoGenerate = false) val id: Int? = null)






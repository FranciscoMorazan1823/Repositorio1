package com.example.determinacion.inventario

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION

class NoteAdapter(private val onItemClickListener: (Note) -> Unit)
    : ListAdapter<Note, NoteAdapter.NoteHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent,
            false)
        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        with(getItem(position)) {
            holder.tvname.text = name
            holder.tvcode.text = code
            holder.tvstock.text = stock.toString()
            holder.tvprecioCompra.text=precioCompra.toString()
            holder.tvprecioVenta.text=precioVenta.toString()

        }
    }

    fun getNoteAt(position: Int) = getItem(position)


    inner class NoteHolder(iv: View) : RecyclerView.ViewHolder(iv) {

        val tvname: TextView = itemView.findViewById(R.id.text_view_name)

        val tvcode: TextView = itemView.findViewById(R.id.text_view_code)

        val tvstock: TextView = itemView.findViewById(R.id.text_view_stock)

        val tvprecioCompra: TextView = itemView.findViewById(R.id.text_view_precioCompra)

        val tvprecioVenta: TextView = itemView.findViewById(R.id.text_view_precioVenta)


        init {
            itemView.setOnClickListener {
                if(adapterPosition != NO_POSITION)
                    onItemClickListener(getItem(adapterPosition))
            }
        }

    }
}

private val diffCallback = object : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note) =
        oldItem.name == newItem.name
                && oldItem.code == newItem.code

}
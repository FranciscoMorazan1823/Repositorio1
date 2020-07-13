package com.pedroroig.architectureexamplecondinginflow

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


const val ADD_NOTE_REQUEST = 1
const val EDIT_NOTE_REQUEST = 2

class MainActivity : AppCompatActivity() {

    private lateinit var vm: NoteViewModel
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        setUpListeners()

        vm = ViewModelProviders.of(this)[NoteViewModel::class.java]

        vm.getAllNotes().observe(this, Observer {
            Log.i("Notes observed", "$it")

            adapter.submitList(it)
        })

    }

    private fun setUpListeners() {
        button_add_note.setOnClickListener {
            val intent = Intent(this, AddEditNoteActivity::class.java)
            startActivityForResult(intent, ADD_NOTE_REQUEST)
        }

        // swipe listener
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, LEFT or RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val note = adapter.getNoteAt(viewHolder.adapterPosition)
                vm.delete(note)
            }

        }).attachToRecyclerView(recycler_view)
    }

    private fun setUpRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        adapter = NoteAdapter { clickedNote ->
            val intent = Intent(this, AddEditNoteActivity::class.java)
            intent.putExtra(EXTRA_ID, clickedNote.id)
            intent.putExtra(EXTRA_NAME, clickedNote.name)
            intent.putExtra(EXTRA_CODE, clickedNote.code)
            intent.putExtra(EXTRA_STOCK, clickedNote.stock)
            intent.putExtra(EXTRA_COMPRA, clickedNote.precioCompra)
            intent.putExtra(EXTRA_VENTA, clickedNote.precioVenta)

            startActivityForResult(intent, EDIT_NOTE_REQUEST)
        }
        recycler_view.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null && requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            val name: String = data.getStringExtra(EXTRA_NAME)
            val code: String =
                data.getStringExtra(EXTRA_CODE)

            val stock: Int = data.getStringExtra(EXTRA_STOCK)
            val precioCompra: Float = data.getStringExtra(EXTRA_COMPRA)
            val precioVenta: Float = data.getStringExtra(EXTRA_VENTA)

            vm.insert(Note(name, code, stock ,precioCompra,precioVenta))
            Toast.makeText(this, "Note inserted!", Toast.LENGTH_SHORT).show()

        } else if(data != null && requestCode == EDIT_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            val id = data.getIntExtra(EXTRA_ID, -1)
            if(id == -1) {
                Toast.makeText(this, "Note couldn't be updated!", Toast.LENGTH_SHORT).show()
                return
            }
            val name: String = data.getStringExtra(EXTRA_NAME)
            val code: String =
                data.getStringExtra(EXTRA_CODE)

            val stock: Int = data.getStringExtra(EXTRA_STOCK)
            val precioCompra: Float = data.getStringExtra(EXTRA_COMPRA)
            val precioVenta: Float = data.getStringExtra(EXTRA_VENTA)

            vm.update(Note(name, code, stock ,precioCompra,precioVenta))
            Toast.makeText(this, "Note updated!", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this, "Note not saved!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_all_notes -> {
                vm.deleteAllNotes()
                Toast.makeText(this, "All notes deleted!", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

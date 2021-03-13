package ipvc.estg.cidadeinteligente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ipvc.estg.cidadeinteligente.adapter.LineAdapter
import ipvc.estg.cidadeinteligente.dataclasses.Nota
import kotlinx.android.synthetic.main.activity_notas.*

class Notas : AppCompatActivity() {


    private lateinit var myList: ArrayList<Nota>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)


        myList = ArrayList<Nota>()

        //Virá p.e. de WS
        for(i in 0 until 500) {
            myList.add(Nota("Nota $i", "Descrição $i" ))
        }

        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)


        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, NovaNota::class.java)
            startActivity(intent)
        }
    }

    }
/*
    fun insert(view: View) {
        myList.add(0, Nota("Nota XXX", "Descrição XXX"))
        recycler_view.adapter?.notifyDataSetChanged()
    }*/



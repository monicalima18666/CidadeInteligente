package ipvc.estg.cidadeinteligente

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
            myList.add(Nota("Nota $i", "Descrição $i"))
        }

        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)


            val fab = findViewById<FloatingActionButton>(R.id.fab)
            fab.setOnClickListener {
                val intent = Intent(this, NovaNota::class.java)
                startActivity(intent)
                }

        recycler_view.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

  /*      // Configurando o gerenciador de layout para ser uma lista horizontal.
        var layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view.layoutManager = layoutManager

*/
    /*
        // Criando o GridLayoutManager com duas colunas, descritas no segundo argumento.
        layoutManager = GridLayoutManager(this, 2)
        recycler_view.layoutManager = layoutManager*/



        }


    }
/*
    fun insert(view: View) {
        myList.add(0, Nota("Nota XXX", "Descrição XXX"))
        recycler_view.adapter?.notifyDataSetChanged()
    }*/



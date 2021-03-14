package ipvc.estg.cidadeinteligente

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ipvc.estg.cidadeinteligente.adapter.LineAdapter
import ipvc.estg.cidadeinteligente.adapter.NotaAdapter
import ipvc.estg.cidadeinteligente.dataclasses.Nota
import ipvc.estg.cidadeinteligente.viewModel.NotaViewModel
import kotlinx.android.synthetic.main.activity_notas.*


class Notas : AppCompatActivity() {


    private lateinit var notaViewModel: NotaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)

       // recycler view

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = NotaAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

       // view model
        notaViewModel = ViewModelProvider(this).get(NotaViewModel::class.java)
        notaViewModel.allNotas.observe(this, Observer { notas ->
            // Update the cached copy of the words in the adapter.
            notas?.let { adapter.setNotas(it)}
        })

/*

        myList = ArrayList<Nota>()

        //Virá p.e. de WS
        for(i in 0 until 500) {
            myList.add(Nota("Nota $i", "Descrição $i"))
        }

        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)
*/


            val fab = findViewById<FloatingActionButton>(R.id.fab)
            fab.setOnClickListener {
                val intent = Intent(this, NovaNota::class.java)
                startActivity(intent)
                }




        recyclerview.addItemDecoration(
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



package ipvc.estg.cidadeinteligente.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.cidadeinteligente.R
import ipvc.estg.cidadeinteligente.entities.Nota

class NotaAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<NotaAdapter.NotaViewHolder>()  {


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notas = emptyList<Nota>()

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloItemView: TextView = itemView.findViewById(R.id.titulo)
        val descricaoItemView: TextView = itemView.findViewById(R.id.descricao)
        val delete : ImageButton = itemView.findViewById(R.id.delete)
        val edit : ImageButton= itemView.findViewById(R.id.edit)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerline, parent, false)
        return NotaViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val current = notas[position]
        holder.tituloItemView.text = current.id.toString() + " - " + current.titulo
        holder.descricaoItemView.text = current.descricao
        //chamar os botoes

    }

    internal fun setNotas (notas: List<Nota>) {
        this.notas = notas
        notifyDataSetChanged()
    }

    override fun getItemCount() = notas.size
}
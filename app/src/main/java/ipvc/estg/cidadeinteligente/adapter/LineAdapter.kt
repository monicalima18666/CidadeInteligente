package ipvc.estg.cidadeinteligente.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import ipvc.estg.cidadeinteligente.R
import ipvc.estg.cidadeinteligente.dataclasses.Nota
import kotlinx.android.synthetic.main.recyclerline.view.*

class LineAdapter(val list: ArrayList<Nota>):RecyclerView.Adapter<LineViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerline, parent, false);
        return LineViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
        val currentPlace = list[position]

        holder.titulo.text = currentPlace.titulo
        holder.descricao.text = currentPlace.descricao


    }

}

class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titulo = itemView.titulo
    val descricao = itemView.descricao
    //val delete = itemView.findViewById<ImageButton>(R.id.delete);
    //val edit = itemView.findViewById<ImageButton>(R.id.edit);



}

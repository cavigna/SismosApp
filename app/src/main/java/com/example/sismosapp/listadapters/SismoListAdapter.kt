package com.example.sismosapp.listadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sismosapp.databinding.ItemRowBinding
import com.example.sismosapp.model.Sismo

class SismoListAdapter(private val extractorDeItem: ExtractorDeItem): ListAdapter<Sismo, MyViewHolder>(SismoComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sismo = getItem(position)

        with(holder.binding){
            imageView.load(sismo.mapa)
            tvHora.text = sismo.horaLocal
            tvMagnitud.text = sismo.magnitud
            tvProfundidad.text = sismo.profundidad
            tvReferencia.text = sismo.referencia


        }

        holder.binding.cardView.setOnClickListener {
            extractorDeItem.alHacerClick(sismo)
        }
    }

    interface ExtractorDeItem{
        fun alHacerClick(sismo: Sismo)
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemRowBinding.bind(itemView)

    companion object{
        fun create(parent: ViewGroup): MyViewHolder{
            val layoutInflaterB = LayoutInflater.from(parent.context)
            val binding = ItemRowBinding.inflate(layoutInflaterB, parent, false)

            return MyViewHolder(binding.root)
        }
    }
}

class SismoComparator : DiffUtil.ItemCallback<Sismo>(){
    override fun areItemsTheSame(oldItem: Sismo, newItem: Sismo): Boolean {
       return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Sismo, newItem: Sismo): Boolean {
        return oldItem.horaLocal == newItem.horaLocal
    }

}

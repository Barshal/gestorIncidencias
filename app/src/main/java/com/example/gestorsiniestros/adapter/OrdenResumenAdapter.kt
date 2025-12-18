package com.example.gestorsiniestros.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.databinding.ItemRecyclerOrdenresumenBinding

// 1. CORRECCIÓN: 'lista' ahora es 'private var' en el constructor.
//    Esto la convierte en una propiedad de la clase, accesible y modificable.
//    He eliminado el listener por ahora para simplificar, puedes añadirlo de nuevo si lo necesitas.
class OrdenResumenAdapter(
    private var lista: List<OrdenEstado>,
    private val contexto: Context
) : RecyclerView.Adapter<OrdenResumenAdapter.MyHolder>() {

    // 2. CORRECCIÓN: 'MyHolder' ahora es más simple. Solo define sus vistas y el listener.
    inner class MyHolder(var binding: ItemRecyclerOrdenresumenBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) { // Buena práctica para evitar crashes
                val clickedItem = lista[position]
                // Aquí puedes manejar el clic, por ejemplo, usando un listener.
                // listener.onItemClick(clickedItem)
            }
        }
    }

    fun actualizarLista(nuevaLista: List<OrdenEstado>) {
        this.lista = nuevaLista
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemRecyclerOrdenresumenBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: OrdenEstado = lista[position]
        holder.binding.tvTitle.text = item.textoEstado
        holder.binding.tvCount.text = item.ordenesCount.toString()
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}

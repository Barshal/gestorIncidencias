package com.example.gestorsiniestros.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestorsiniestros.data.model.OrdenEstado
import com.example.gestorsiniestros.databinding.ItemRecyclerOtAgrupadoBinding

class OrdenResumenAdapter(
    private var lista: List<OrdenEstado>,
    // 1. Recibe la interfaz del listener como parámetro.
    private val listener: OnOrdenEstadoClickListener
) : RecyclerView.Adapter<OrdenResumenAdapter.MyHolder>() {

    // El ViewHolder ahora solo se encarga de configurar las vistas y el evento de clic.
    inner class MyHolder(val binding: ItemRecyclerOtAgrupadoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ordenEstado: OrdenEstado) {
            // Configura los datos de la vista
            binding.tvTitle.text = ordenEstado.textoEstado
            binding.tvCount.text = ordenEstado.ordenesCount.toString()

            itemView.setOnClickListener {
                listener.onItemClicked(ordenEstado)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemRecyclerOtAgrupadoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // 3. Llama al metodo bind para configurar datos y el listener de clic.
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    fun actualizarLista(nuevaLista: List<OrdenEstado>) {
        this.lista = nuevaLista
        notifyDataSetChanged()
    }
}
    
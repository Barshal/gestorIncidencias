package com.example.gestorsiniestros.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View // --> (2) Importa View para el OnClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.gestorsiniestros.databinding.ItemRecyclerOrdenresumenBinding
import com.example.gestorsiniestros.model.OrdenEstado
import com.example.gestorsiniestros.ui.HomeActivity

class OrdenResumenAdapter(var lista: List<OrdenEstado>, var contexto: Context, private val listener: HomeActivity) :
    RecyclerView.Adapter<OrdenResumenAdapter.MyHolder>() {

    interface OnItemClickListener {
        fun onItemClick(ordenEstado: OrdenEstado)
    }
    inner class MyHolder(var binding: ItemRecyclerOrdenresumenBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
                binding.root.setOnClickListener(this)
            }

        // --> (7) Implementa el método onClick
        override fun onClick(v: View?) {
            val position = adapterPosition
        }
    }

    //Petorna la plantilla inflada/soporte/holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding: ItemRecyclerOrdenresumenBinding = ItemRecyclerOrdenresumenBinding.inflate(
            LayoutInflater.from(contexto), parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val item: OrdenEstado = lista[position]
        holder.binding.tvTitle.text = item.textoEstado
        holder.binding.tvCount.text = item.ordenesCount.toString()
    }

    // Retorna el numero de elementos que hay en la lista
    override fun getItemCount(): Int {
        return lista.size
    }
}
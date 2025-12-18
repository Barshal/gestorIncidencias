package com.example.gestorsiniestros.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestorsiniestros.data.model.OrdenResumen
import com.example.gestorsiniestros.databinding.ItemRecyclerOtResumenBinding

class OrdenTrabajoResumenAdapter (var lista: ArrayList<OrdenResumen>, contexto: Context): RecyclerView.Adapter<OrdenTrabajoResumenAdapter.MyHolder>() {
    inner class MyHolder(var binding: ItemRecyclerOtResumenBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemRecyclerOtResumenBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val item: OrdenResumen = lista[position]
        val restoDir = item.codigoPostal + " - " + item.poblacionOrden +" (" + item.provinciaOrden + ")"

        holder.binding.tvOtNumber.text = item.id.toString()
        holder.binding.tvAddress.text = item.domicilioOrden
        holder.binding.tvCity.text = restoDir
        holder.binding.tvAppointmentInfo.text = item.fechaApertura

    }

    override fun getItemCount(): Int {
        return lista.size
    }

}
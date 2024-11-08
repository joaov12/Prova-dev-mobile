package com.jv.prova2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SemestreAdapter(
    private val semestres: List<Semestre>,
    private val onClick: (Semestre) -> Unit
) : RecyclerView.Adapter<SemestreAdapter.SemestreViewHolder>() {

    inner class SemestreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(semestre: Semestre) {
            itemView.findViewById<TextView>(R.id.semestreTextView).text = "${semestre.ano} - ${semestre.semestre}"
            itemView.setOnClickListener { onClick(semestre) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SemestreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.semestre_item, parent, false)
        return SemestreViewHolder(view)
    }

    override fun onBindViewHolder(holder: SemestreViewHolder, position: Int) {
        holder.bind(semestres[position])
    }

    override fun getItemCount(): Int = semestres.size
}

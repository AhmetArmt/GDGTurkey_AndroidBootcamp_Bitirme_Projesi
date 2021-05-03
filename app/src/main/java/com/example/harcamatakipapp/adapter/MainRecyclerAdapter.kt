package com.example.harcamatakipapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.model.Harcama
import kotlinx.android.synthetic.main.recyclerow_tasarimi.view.*

class MainRecyclerAdapter (var harcamaListesi : ArrayList<Harcama>) : RecyclerView.Adapter<MainRecyclerAdapter.harcamaViewHolder>() {

    inner class harcamaViewHolder(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): harcamaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rowView = inflater.inflate(R.layout.recyclerow_tasarimi,parent,false)
        return harcamaViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: harcamaViewHolder, position: Int) {
        holder.itemView.textViewRCVHarcamaBilgisi.text = harcamaListesi.get(position).harcamaBaslik
        holder.itemView.textViewRCVHarcamaTurar.text = harcamaListesi.get(position).harcamaTutari.toString()
       harcamaGorselAyarlarama(holder,position)

    }

    override fun getItemCount(): Int {
       return harcamaListesi.size
    }

   private fun harcamaGorselAyarlarama(holder : harcamaViewHolder , position: Int) {
       if (harcamaListesi.get(position).harcamaTuru == 1) {
           holder.itemView.imageViewRCVHacamaTuru.setImageResource(R.drawable.fatura)
       } else if (harcamaListesi.get(position).harcamaTuru == 2) {
           holder.itemView.imageViewRCVHacamaTuru.setImageResource(R.drawable.kira)
       } else if (harcamaListesi.get(position).harcamaTuru == 3) {
           holder.itemView.imageViewRCVHacamaTuru.setImageResource(R.drawable.alisveris)
       } else if (harcamaListesi.get(position).harcamaTuru == 4) {
           holder.itemView.imageViewRCVHacamaTuru.setImageResource(R.drawable.diger)
       }
   }

}
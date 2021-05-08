package com.example.harcamatakipapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.databinding.RecyclerowTasarimiBinding
import com.example.harcamatakipapp.model.Harcama
import com.example.harcamatakipapp.view.Main_fragmentDirections
import kotlinx.android.synthetic.main.recyclerow_tasarimi.view.*
import kotlin.math.absoluteValue

class MainRecyclerAdapter (var harcamaListesi : ArrayList<Harcama>) : RecyclerView.Adapter<MainRecyclerAdapter.HarcamaViewHolder>(), HarcamaClickListener {



    inner class HarcamaViewHolder(var dbview : RecyclerowTasarimiBinding) : RecyclerView.ViewHolder(dbview.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarcamaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val rowView = inflater.inflate(R.layout.recyclerow_tasarimi,parent,false)

        //DataBinding
        val dbrowView = DataBindingUtil.inflate<RecyclerowTasarimiBinding>(inflater,R.layout.recyclerow_tasarimi,parent,false)
        return HarcamaViewHolder(dbrowView)
    }


    override fun onBindViewHolder(holder: HarcamaViewHolder, position: Int) {
      /*  holder.itemView.textViewRCVHarcamaBilgisi.text = harcamaListesi.get(position).harcamaBaslik
        holder.itemView.textViewRCVHarcamaTurar.text = harcamaListesi.get(position).harcamaTutari.toString()
       harcamaGorselAyarlarama(holder,position)

        */

      //DataBinding
      holder.dbview.rcvHarcamaBilgisi = harcamaListesi[position]



        holder.dbview.rcvListener = this

    }

    override fun getItemCount(): Int {
       return harcamaListesi.size
    }

    override fun tiklandi(view: View) {
        val id = view.harcamaIdXML.text.toString().toInt()
        val action = Main_fragmentDirections.actionMainFragmentToHarcamaDetayiFragment(id)
        Navigation.findNavController(view).navigate(action)
    }

    fun harcamaListesiniGuncelle(yeniharcamaLsitesi : List<Harcama>) {
        harcamaListesi.clear()
        harcamaListesi.addAll(yeniharcamaLsitesi)
        notifyDataSetChanged()
    }


}





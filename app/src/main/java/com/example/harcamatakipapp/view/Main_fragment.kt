package com.example.harcamatakipapp.view

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.adapter.MainRecyclerAdapter
import com.example.harcamatakipapp.viewmodel.Main_fragmentVM
import kotlinx.android.synthetic.main.fragment_kullaniciadi_degistir_fragment.*
import kotlinx.android.synthetic.main.fragment_main_fragment.*

class Main_fragment : Fragment() {

    private var viewModel = Main_fragmentVM()
    private val adapter = MainRecyclerAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_fragment, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.harcamaListesi.clear()
        viewModel.refreshHarcamalar()
        adapter.harcamaListesi.addAll(viewModel.harcamalarListesi)
        mainRCV.layoutManager = LinearLayoutManager(context)
        mainRCV.adapter = adapter

        mainCardView.setOnClickListener {
            val action = Main_fragmentDirections.actionMainFragmentToKullaniciadiDegistirFragment2()
            viewModel.gecisEkle(action,it)
        }

        fabEkle.setOnClickListener {
            val action = Main_fragmentDirections.actionMainFragmentToHarcamaEkleFragment()
            viewModel.gecisEkle(action,it)
        }




    }


}
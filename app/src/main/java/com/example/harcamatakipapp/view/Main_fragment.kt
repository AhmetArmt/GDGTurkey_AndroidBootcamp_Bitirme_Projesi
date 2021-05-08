package com.example.harcamatakipapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.adapter.MainRecyclerAdapter
import com.example.harcamatakipapp.viewmodel.Main_fragmentVM
import kotlinx.android.synthetic.main.fragment_main_fragment.*
import kotlinx.android.synthetic.main.fragment_main_fragment.textView_mainCardView_isim

class Main_fragment : Fragment() {

    private lateinit var viewModel : Main_fragmentVM
    private lateinit var  madapter : MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // viewmodel baglantisi
        viewModel = ViewModelProviders.of(this).get(Main_fragmentVM::class.java)


        //Kullanici adi alici
        val sharedPr = requireActivity().getSharedPreferences("sharedPrefDatas", Context.MODE_PRIVATE)
        val isim = sharedPr.getString("KullaniciAdi","hata")
        textView_mainCardView_isim.text = isim


        //SwipeReflesh islemleri
        swipeRefleshMain.setOnRefreshListener {
            swipeRefleshMain.setColorSchemeResources(R.color.ozel_lacivertAcik)
            swipeRefleshMain.isRefreshing = false
            viewModel
            }


        // ! onemli ! (reflesh isleminide yapiyor)
        viewModel.harcamalariGetir(view.context)



        // kullanici bilgileri ekranina gecis
        mainCardView.setOnClickListener {
            val action = Main_fragmentDirections.actionMainFragmentToKullaniciadiDegistirFragment2()
            findNavController().navigate(action)
        }


        // harcama ekle ekranina gecis
        fabEkle.setOnClickListener  {
            val action = Main_fragmentDirections.actionMainFragmentToHarcamaEkleFragment()
            findNavController().navigate(action)
        }


        // RCV adapter islemleri
        mainRCV.layoutManager = LinearLayoutManager(context)
        madapter = MainRecyclerAdapter(viewModel.harcamalarListesi)
        mainRCV.adapter = madapter



    }



}
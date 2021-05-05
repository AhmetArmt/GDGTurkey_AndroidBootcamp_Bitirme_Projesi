package com.example.harcamatakipapp.view

import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.adapter.MainRecyclerAdapter
import com.example.harcamatakipapp.viewmodel.Main_fragmentVM
import kotlinx.android.synthetic.main.fragment_kullaniciadi_degistir_fragment.*
import kotlinx.android.synthetic.main.fragment_main_fragment.*

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


        // toplam harcamayi duzenler
        val toplamArray = viewModel.toplamHarcamaHesaplayici(view.context)
        var toplam = 0L
        for (h in toplamArray) {
            toplam += h.harcamaTutari
        }
        textView_mainCardView_harcama.text = toplam.toString()


        // ! onemli ! (reflesh isleminide yapiyor)
        viewModel.harcamalariGetir(view.context)

        // kullanici bilgileri ekranina gecis
        mainCardView.setOnClickListener {
            val action = Main_fragmentDirections.actionMainFragmentToKullaniciadiDegistirFragment2()
            viewModel.gecisEkle(action,it)
        }

        // harcama ekle ekranina gecis
        fabEkle.setOnClickListener  {
            val action = Main_fragmentDirections.actionMainFragmentToHarcamaEkleFragment()
            viewModel.gecisEkle(action,it)
        }

        //SwipeReflesh islemleri
        swipeRefleshMain.setOnRefreshListener {
            swipeRefleshMain.setColorSchemeResources(R.color.ozel_lacivertAcik)
            Handler().postDelayed(Runnable {swipeRefleshMain.isRefreshing = false  },3000)
        }




        mainRCV.layoutManager = LinearLayoutManager(context)
        madapter = MainRecyclerAdapter(viewModel.harcamalarListesi)
        mainRCV.adapter = madapter






    }


}
package com.example.harcamatakipapp.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.adapter.MainRecyclerAdapter
import com.example.harcamatakipapp.model.Doviz
import com.example.harcamatakipapp.services.DovizAPIService
import com.example.harcamatakipapp.services.HarcamaDatabase
import com.example.harcamatakipapp.viewmodel.Main_fragmentVM
import kotlinx.android.synthetic.main.fragment_main_fragment.*
import kotlinx.android.synthetic.main.fragment_main_fragment.textView_mainCardView_isim
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main_fragment : Fragment() {

    private lateinit var viewModel : Main_fragmentVM
    private val  madapter = MainRecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_fragment, container, false)
        return view
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // viewmodel baglantisi
        viewModel = ViewModelProviders.of(this).get(Main_fragmentVM::class.java)

        //SharedPreferences
        val sharedPr = requireActivity().getSharedPreferences("sharedPrefDatas", Context.MODE_PRIVATE)

        observeLiveData(view.context)

        // toplam gosterme
        var toplam = viewModel.toplamHarcama(view.context)
        textView_mainCardView_harcama.text = toplam.toString()


        viewModel.refleshDayfaData(view.context,this)


        // RCV adapter islemleri
        mainRCV.layoutManager = LinearLayoutManager(context)
        mainRCV.adapter = madapter

        //Kullanici adi alici
        val isim = sharedPr.getString("KullaniciAdi", "hata")
        textView_mainCardView_isim.text = isim

        //SwipeReflesh islemleri
        swipeRefleshMain.setOnRefreshListener {
            swipeRefleshMain.setColorSchemeResources(R.color.ozel_lacivertAcik)
            swipeRefleshMain.isRefreshing = false
            viewModel.refleshDayfaData(view.context,this)
            Toast.makeText(view.context,"Liste Guncellendi",Toast.LENGTH_SHORT).show()
            textView_mainCardView_harcama.text = viewModel.toplamHarcama(view.context).toString()
        }

        // kullanici bilgileri ekranina gecis
        mainCardView.setOnClickListener {
            val action = Main_fragmentDirections.actionMainFragmentToKullaniciadiDegistirFragment2()
            findNavController().navigate(action)
        }

        // harcama ekle ekranina gecis
        fabEkle.setOnClickListener {
            val action = Main_fragmentDirections.actionMainFragmentToHarcamaEkleFragment()
            findNavController().navigate(action)
        }




        //Dolar Button
        buttonDolar.setOnClickListener {
            viewModel.dolarConventer(view.context,this)
            viewModel.verileriRoomdanGetir(view.context)
            Toast.makeText(view.context,"De??i??iklik Yap??ld?? Sayfay?? Yenileyin",Toast.LENGTH_SHORT).show()
        }

        //Euro Button
        buttonEuro.setOnClickListener {
            viewModel.euroConventer(view.context,this)
            viewModel.refleshDayfaData(view.context,this)
            Toast.makeText(view.context,"De??i??iklik Yap??ld?? Sayfay?? Yenileyin",Toast.LENGTH_SHORT).show()
        }

        //Sterlin Button
        buttonSterlin.setOnClickListener {
        viewModel.sterlinConventer(view.context,this)
        viewModel.verileriRoomdanGetir(view.context)

        Toast.makeText(view.context,"De??i??iklik Yap??ld?? Sayfay?? Yenileyin",Toast.LENGTH_SHORT).show()

        }

        // TL Button
        buttonTL.setOnClickListener {
        viewModel.tlConventer(view.context,this)
        viewModel.verileriRoomdanGetir(view.context)
        Toast.makeText(view.context,"De??i??iklik Yap??ld?? Sayfay?? Yenileyin",Toast.LENGTH_SHORT).show()
        }


    }

    fun observeLiveData (context: Context){
        viewModel.harcamalarListesi.observe(viewLifecycleOwner, Observer {
            madapter.harcamaListesiniGuncelle(it)
        })

        textView_mainCardView_harcama.text = viewModel.toplamHarcama(context).toString()



    }


}




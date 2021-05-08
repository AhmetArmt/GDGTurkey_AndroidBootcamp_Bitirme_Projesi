package com.example.harcamatakipapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.databinding.FragmentHarcamaDetayiFragmentBinding
import com.example.harcamatakipapp.viewmodel.Harcama_detayi_fragmentVM
import kotlinx.android.synthetic.main.fragment_harcama_detayi_fragment.*


class Harcama_detayi_fragment : Fragment() {

    private lateinit var viewModel : Harcama_detayi_fragmentVM
    private lateinit var dataBinding : FragmentHarcamaDetayiFragmentBinding
    private var harcamaId : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_harcama_detayi_fragment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // argumanlarimiz
        arguments?.let {
            harcamaId = Harcama_detayi_fragmentArgs.fromBundle(it).harcamaİd
        }

        viewModel = ViewModelProviders.of(this).get(Harcama_detayi_fragmentVM::class.java)

        viewModel.harcamaDetayiniGetir(view.context,harcamaId)



        obsLiveData()


        // Alertview ile secilen veriyi silip silmek istemedigimizi sorar
        button_harcamaDetayi_sil.setOnClickListener {

            val alert = AlertDialog.Builder(view.context)

            alert.setTitle("Harcama Detayı")
            alert.setMessage("Harcamayı silmek istediğinizden emin misiniz ?")
            alert.setIcon(R.drawable.alertview_delete)

            alert.setPositiveButton("Evet") { dialogInterface, listener ->
                viewModel.harcamaSil(view.context,harcamaId)
                val action = Harcama_detayi_fragmentDirections.actionHarcamaDetayiFragmentToMainFragment()
                findNavController().navigate(action)
                Toast.makeText(view.context,"Harcamanız Silindi",Toast.LENGTH_SHORT).show()
            }

            alert.setNegativeButton("Hayır") {dialogInterface, listener ->
                return@setNegativeButton
            }
            alert.create().show()
        }

    }




    fun obsLiveData() {
        viewModel.harcamaLiveData.observe(viewLifecycleOwner, Observer {
            it.let {
                dataBinding.secilenHarcama = it
            }
        }) }




}
package com.example.harcamatakipapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.harcamatakipapp.R
import com.example.harcamatakipapp.model.Harcama
import kotlinx.android.synthetic.main.fragment_harcama_detayi_fragment.*


fun longToStringForDataBinding (long: Long) : String {
    return long.toString()
}

@BindingAdapter("android:GorselAyarlayici")
fun setImage(imageView : ImageView, harcamaTuru : Int){
    if (harcamaTuru == 1) imageView.setImageResource(R.drawable.fatura)
    if (harcamaTuru == 2) imageView.setImageResource(R.drawable.kira)
    if (harcamaTuru == 3) imageView.setImageResource(R.drawable.alisveris)
    if (harcamaTuru == 4) imageView.setImageResource(R.drawable.diger)
}
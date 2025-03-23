package com.example.foodorderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.data.entitiy.Yemekler
import com.example.foodorderapp.databinding.SepetcardBinding

class SepetAdapter(var mContext: Context, var YemeklerListesi: List<Yemekler>): RecyclerView.Adapter<SepetAdapter.SepetTasarimTutucu>() {

    inner class SepetTasarimTutucu(var tasarim: SepetcardBinding):
            RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetTasarimTutucu {
        val binding = SepetcardBinding.inflate(LayoutInflater.from(mContext), parent,false)
        return SepetTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: SepetTasarimTutucu, position: Int) {
        val yemek = YemeklerListesi.get(position)
        val t = holder.tasarim

        t.yemekAdiSepet.text = yemek.yemek_adi
        t.yemekFiyatiSepet.text = yemek.yemek_fiyat.toString()
    }

    override fun getItemCount(): Int {
        return YemeklerListesi.size
    }
}
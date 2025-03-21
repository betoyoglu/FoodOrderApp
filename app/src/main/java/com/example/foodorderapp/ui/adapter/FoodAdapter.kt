package com.example.foodorderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderapp.data.entitiy.Yemekler
import com.example.foodorderapp.databinding.CardTasarimBinding
import com.example.foodorderapp.ui.fragment.MainPageFragmentDirections

class FoodAdapter(var mContext: Context, var YemeklerListesi:List<Yemekler>)
    :RecyclerView.Adapter<FoodAdapter.CardTasarimTutucu>(){

        inner class CardTasarimTutucu(var tasarim: CardTasarimBinding):
                RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val food = YemeklerListesi.get(position)
        val t = holder.tasarim

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(500,750).into(t.imageFood)

        t.textFood.text = "${food.yemek_adi}"

        t.cardViewFood.setOnClickListener{
            val gecis =MainPageFragmentDirections.mainToDetail(food)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return YemeklerListesi.size
    }
}
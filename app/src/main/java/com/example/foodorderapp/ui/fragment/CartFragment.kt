package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.R
import com.example.foodorderapp.data.entitiy.Yemekler
import com.example.foodorderapp.databinding.FragmentCartBinding
import com.example.foodorderapp.ui.adapter.FoodAdapter
import com.example.foodorderapp.ui.adapter.SepetAdapter

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        binding.rvSepet.layoutManager= LinearLayoutManager(requireContext())

        val YemeklerListesi=ArrayList<Yemekler>()
        val f1 = Yemekler("1", "ayran", "ayran.png", 10)
        val f2 = Yemekler("2", "baklava", "baklava.png", 10)
        val f3 = Yemekler("3", "fanta", "fanta.png", 10)

        YemeklerListesi.add(f1)
        YemeklerListesi.add(f2)
        YemeklerListesi.add(f3)

        val SepetAdapter= SepetAdapter(requireContext(), YemeklerListesi)
        binding.rvSepet.adapter=SepetAdapter
        return binding.root
    }

    }

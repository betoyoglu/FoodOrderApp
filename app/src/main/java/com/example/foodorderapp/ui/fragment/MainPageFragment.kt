package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodorderapp.R
import com.example.foodorderapp.data.entitiy.Yemekler
import com.example.foodorderapp.databinding.FragmentMainPageBinding
import com.example.foodorderapp.ui.adapter.FoodAdapter


class MainPageFragment : Fragment() {

private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false)

        binding.toolbarMain.title = "Food"

        binding.rvMain.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val YemeklerListesi=ArrayList<Yemekler>()
        val f1 = Yemekler("1", "ayran", "ayran.png", 10)
        val f2 = Yemekler("2", "baklava", "baklava.png", 10)
        val f3 = Yemekler("3", "fanta", "fanta.png", 10)

        YemeklerListesi.add(f1)
        YemeklerListesi.add(f2)
        YemeklerListesi.add(f3)

        val FoodAdapter=FoodAdapter(requireContext(), YemeklerListesi)
        binding.rvMain.adapter=FoodAdapter

        return binding.root
    }


    }

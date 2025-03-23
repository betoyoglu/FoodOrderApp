package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater,container,false)

        val bundle : BottomSheetFragmentArgs by navArgs()
        val food = bundle.yemekler

        binding.yemekAdiBottom.text = "${food.yemek_adi}"
        binding.yemekFiyatiBottom.text = "${food.yemek_fiyat}TL"

        binding.showMoreBottom.setOnClickListener {
            val navController = requireParentFragment().findNavController()
            val gecis =BottomSheetFragmentDirections.bottomToDetail(food)
            navController.navigate(gecis)
        }


        return binding.root
    }


}

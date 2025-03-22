package com.example.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding:FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val bundle : DetailFragmentArgs by navArgs()
        val food = bundle.yemekler

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(requireContext()).load(url)
            .apply(RequestOptions.circleCropTransform())
            .override(500,750)
            .into(binding.ivFood)

        binding.textYemekAdi.text = "${food.yemek_adi}"
        binding.textYemekFiyati.text = "${food.yemek_fiyat}"

        foodAmount()
        return binding.root
    }

    private fun foodAmount() {
        var quantity = 1

        // - Button Click Listener
        binding.decreaseButton.setOnClickListener {
            if (quantity > 0) {  // Ensuring quantity does not go below 0
                quantity -= 1
                binding.foodNum.text = quantity.toString()
            }
        }

        // + Button Click Listener
        binding.increaseButton.setOnClickListener {
            quantity += 1
            binding.foodNum.text = quantity.toString()
        }
    }


}
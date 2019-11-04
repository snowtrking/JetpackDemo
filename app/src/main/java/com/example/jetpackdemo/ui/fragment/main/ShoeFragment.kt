package com.example.jetpackdemo.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.jetpackdemo.R
import com.example.jetpackdemo.viewmodel.CustomViewModelProvider
import com.example.jetpackdemo.viewmodel.ShoeModel

class ShoeFragment : Fragment(){

    private val viewModel:ShoeModel by viewModels{
        CustomViewModelProvider.providerShoeModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shoe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
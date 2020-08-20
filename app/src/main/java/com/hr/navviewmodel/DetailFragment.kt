package com.hr.navviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.hr.navviewmodel.databinding.FragmentDetailBinding
import com.hr.navviewmodel.databinding.FragmentMasterBinding

class DetailFragment : Fragment() {

    lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        var binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,R.layout.fragment_detail,container,false)
        binding.data = viewModel
        binding.lifecycleOwner = activity

        //返回按键
        binding.button6.setOnClickListener {
            var findNavController = Navigation.findNavController(it)
            findNavController.navigate(R.id.action_detailFragment_to_masterFragment)
        }

        return binding.root
    }

}
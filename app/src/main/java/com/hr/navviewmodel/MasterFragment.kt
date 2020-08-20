package com.hr.navviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.hr.navviewmodel.databinding.FragmentMasterBinding


class MasterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        var binding = DataBindingUtil.inflate<FragmentMasterBinding>(
            inflater,
            R.layout.fragment_master,
            container,
            false
        )
        binding.data = viewModel
        binding.lifecycleOwner = activity

        binding.seekBar2.setProgress(viewModel.numberLiveData?.value!!)
        binding.seekBar2.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //将进度写到viewmodel中
                viewModel.numberLiveData?.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        //按钮导航
        binding.button.setOnClickListener {
            var findNavController = Navigation.findNavController(it)
            findNavController.navigate(R.id.action_masterFragment_to_detailFragment)
        }

        return binding.root
    }

}
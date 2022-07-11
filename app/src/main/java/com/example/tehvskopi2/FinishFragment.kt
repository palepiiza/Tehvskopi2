package com.example.tehvskopi2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tehvskopi2.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Selesai"

        val binding : FragmentFinishBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_finish, container, false)

        var args = arguments?.let { FinishFragmentArgs.fromBundle(it) }
        binding.explain.text = args?.result

        return binding.root
    }


}
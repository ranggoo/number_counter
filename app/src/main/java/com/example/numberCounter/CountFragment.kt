package com.example.numberCounter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.numberCounter.databinding.FragmentCountBinding

class CountFragment : Fragment() {

    private var _binding: FragmentCountBinding? = null

    private val binding get() = _binding!!

    private var countNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() = with(binding) {

        ivPlus.setOnClickListener {
            countNumber ++
            tvCount.text = countNumber.toString()
        }
        ivMinus.setOnClickListener {
            countNumber --
            tvCount.text = countNumber.toString()
        }
        ivReset.setOnClickListener {
            countNumber = 0
            tvCount.text = countNumber.toString()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
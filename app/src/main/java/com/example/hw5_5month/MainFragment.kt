package com.example.hw5_5month

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw5_5month.databinding.FragmentMainBinding


class MainFragment : Fragment(), ItemOnClickListener {

    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences = requireContext().getSharedPreferences("setting", Context.MODE_PRIVATE)
       val isShow : Boolean=preferences.getBoolean("isShow", false)

        if(isShow){
            findNavController().navigate(R.id.secondFragment)
        }

        val list = ArrayList<BoardModel>()
        list.add(BoardModel(R.drawable.ic_one, "ONE"))
        list.add(BoardModel(R.drawable.ic_two, "TWO"))
        list.add(BoardModel(R.drawable.ic_three, "THREE"))
        list.add(BoardModel(R.drawable.ic_four, "THE END"))


        val adapter = BoardAdapter(list, this)
        binding.veiewPager.adapter = adapter


    }

    override fun itemClick() {
        val preferences = requireContext().getSharedPreferences("setting", Context.MODE_PRIVATE)
        preferences.edit().putBoolean("isShow", true).apply()
        findNavController().navigate(R.id.secondFragment)
    }

    override fun btnClick1page() {
        binding.veiewPager.currentItem = 1
    }

    override fun btnClick2page() {
        binding.veiewPager.currentItem = 2
    }

    override fun btnClick3page() {
        binding.veiewPager.currentItem=3
    }

}




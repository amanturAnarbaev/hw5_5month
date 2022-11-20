package com.example.hw5_5month

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw5_5month.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class MainFragment : Fragment(), ItemOnClickListener {


    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var shared: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val list = ArrayList<BoardModel>()
        list.add(BoardModel(R.drawable.ic_one, "ONE"))
        list.add(BoardModel(R.drawable.ic_two, "TWO"))
        list.add(BoardModel(R.drawable.ic_three, "THREE"))
        list.add(BoardModel(R.drawable.ic_four, "THE END"))


        val adapter = BoardAdapter(list, this)
        binding.veiewPager.adapter = adapter

        if (shared.getBoolean("isShow", false)) {
            findNavController().navigate(R.id.secondFragment)
        }
    }

    override fun itemClick() {

        changedShared()
        findNavController().navigate(R.id.secondFragment)
    }

    override fun btnClick1page() {
        binding.veiewPager.currentItem = 1
    }

    override fun btnClick2page() {
        binding.veiewPager.currentItem = 2
    }

    override fun btnClick3page() {
        binding.veiewPager.currentItem = 3
    }

    fun changedShared() {
        shared.edit().putBoolean("isShow", true).apply()
    }

}




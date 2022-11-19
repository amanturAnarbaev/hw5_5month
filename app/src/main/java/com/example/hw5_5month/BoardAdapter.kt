package com.example.hw5_5month

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hw5_5month.databinding.ItemBoardBinding

class BoardAdapter(private val list : ArrayList<BoardModel> , private val listener : ItemOnClickListener) : RecyclerView.Adapter<BoardAdapter.BoaddModelViewHolder>() {
     inner class BoaddModelViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(boardModel : BoardModel){
                binding.imageItem.load(boardModel.image)
                binding.name.text=boardModel.name

                binding.next.setOnClickListener{
                    if (adapterPosition == list.size-1){
                        listener.itemClick()
                    }else if(adapterPosition == list.size-4){
                        listener.btnClick1page()
                    }else if(adapterPosition == list.size-3){
                        listener.btnClick2page()
                    }else if(adapterPosition == list.size-2){
                        listener.btnClick3page()
                    }
                }


            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoaddModelViewHolder {
        return BoaddModelViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoaddModelViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
package ru.myitschool.lab23

import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.lab23.databinding.ItemLayoutBinding

class ItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    fun setItem(item: ExpInc){
        binding.typeTextView.text = item.type
        binding.sumTextView.text = item.sum.toString()
    }
}
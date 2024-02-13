package ru.myitschool.lab23

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import ru.myitschool.lab23.databinding.ItemLayoutBinding


class RecyclerViewAdapter(private val context: Context, private val viewModel: ExpIncViewModel) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        val holder = ItemViewHolder(binding)

        binding.root.setOnLongClickListener {
            val position = holder.adapterPosition
            showContextMenu(binding.root, position)
            true
        }
        return holder
    }

    override fun getItemCount(): Int {
        return viewModel.arrayOfExpenses.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setItem(viewModel.arrayOfExpenses.value?.get(position) ?: ExpInc("0", 0.0))
    }

    private fun showContextMenu(view: View, position: Int) {
        val popupMenu = PopupMenu(context, view)
        popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu)

//        popupMenu.setOnMenuItemClickListener { item ->
//            when (item.itemId) {
//                // Обработка выбранного пункта меню
//                R.id.menu_item_delete -> {
//                    // Логика удаления элемента
//                    true
//                }
//                else -> false
//            }
//        }

        popupMenu.show()
    }
}
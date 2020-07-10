package com.example.habitstracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter_list(private val list:List<Habits>) : RecyclerView.Adapter<ViewHolderList>(){
    class Holder(val view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolderList(inflater, parent)
    }

    override fun getItemCount(): Int = list?.size

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        val habits: Habits = list[position]
        holder.bind(habits)
    }
}
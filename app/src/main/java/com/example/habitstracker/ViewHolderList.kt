package com.example.habitstracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderList(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_list,parent,false)){

    private var mNama: TextView? = null

    init{
        mNama = itemView.findViewById(R.id.hablist)
    }

    fun bind(habits: Habits){
        mNama?.text = habits.nama
    }
}
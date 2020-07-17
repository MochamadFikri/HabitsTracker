package com.example.habitstracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HabitsListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<HabitsListAdapter.HabitsViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var habits = emptyList<Habits>() // Cached copy of words

    inner class HabitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val habitsItemNama: TextView = itemView.findViewById(R.id.textNama)
        val habitsItemWaktu: TextView = itemView.findViewById(R.id.textWaktu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitsViewHolder {
        val itemView = inflater.inflate(R.layout.habits_item, parent, false)
        return HabitsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HabitsViewHolder, position: Int) {
        val current = habits[position]
        holder.habitsItemNama.text = current.nama
        holder.habitsItemWaktu.text = current.waktu
    }

    internal fun setHabits(habits: List<Habits>) {
        this.habits = habits
        notifyDataSetChanged()
    }

    override fun getItemCount() = habits.size
}
package com.mochamadfghd.habitstracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5

class HabitsListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<HabitsListAdapter.HabitsViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var habits = emptyList<Habits>()
    private lateinit var mItemClickListener: onItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitsViewHolder {
        val itemView = inflater.inflate(R.layout.habits_item, parent, false)
        return HabitsViewHolder(itemView)
    }

    override fun getItemCount() = habits.size
    
    override fun onBindViewHolder(holder: HabitsViewHolder, position: Int) {

        val current = habits[position]
        holder.habitsItemNama.text = current.nama
        holder.habitsItemWaktu.text = current.waktu

        holder.bind(habits.get(position),mItemClickListener,position)

    }


    inner class HabitsViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val habitsItemNama: TextView = itemView.findViewById(R.id.textNama)
        val habitsItemWaktu: TextView = itemView.findViewById(R.id.textWaktu)
        fun bind(habits: Habits, clickListener: onItemClickListener,position: Int){
            itemView.setOnClickListener {
                clickListener.itemClickListener(habits,position)
            }
        }
    }

    internal fun setHabits(habits: List<Habits>, clickListener: onItemClickListener) {
        this.habits = habits
        this.mItemClickListener = clickListener
        notifyDataSetChanged()
    }

    interface onItemClickListener{
        fun itemClickListener(habits: Habits,position: Int)
    }
}
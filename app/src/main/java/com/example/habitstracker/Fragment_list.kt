package com.example.habitstracker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*


class Fragment_list : Fragment() {
    private val habits : ArrayList<Habits> = ArrayList()

    private var studentDatabase:HabitsDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mNama = "HABIT 2"

        val habit = Habits(mNama)

        println("${habit}")

    }


    companion object{
        fun newInstance(): Fragment_list = Fragment_list()
    }
}

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


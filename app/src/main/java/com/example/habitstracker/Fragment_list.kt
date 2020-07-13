package com.example.habitstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.list_list.view.*

class Fragment_list : Fragment() {

    val listHabits = listOf(
        Habits("Meminum Coklat Panas"),
        Habits("Bermain Tiktaktuk")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycle_list.apply {
            layoutManager = LinearLayoutManager(activity)

            adapter = Adapter_list(listHabits)
        }
    }

    companion object{
        fun newInstance(): Fragment_list = Fragment_list()
    }
}


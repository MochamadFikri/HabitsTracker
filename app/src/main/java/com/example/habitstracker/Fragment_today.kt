package com.example.habitstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment_today : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    companion object{
        fun newInstance(): Fragment_today{
            val fragment = Fragment_today()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
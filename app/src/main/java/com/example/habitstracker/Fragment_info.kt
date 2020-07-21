package com.example.habitstracker

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment_info : Fragment() {

    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    companion object{
        fun newInstance(): Fragment_info{
            val fragment = Fragment_info()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
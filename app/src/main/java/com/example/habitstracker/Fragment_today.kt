package com.example.habitstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_today.*
import java.text.SimpleDateFormat

class Fragment_today : Fragment() {
    var currentDay : String = SimpleDateFormat("E", java.util.Locale.getDefault()).format(
        java.util.Date()
    )
    var currentDate: String = SimpleDateFormat("dd M yyyy", java.util.Locale.getDefault()).format(
        java.util.Date()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        hari.setText(currentDay)
        tanggal.setText(currentDate)
        super.onViewCreated(view, savedInstanceState)
    }

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
package com.mochamadfghd.habitstracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_w3.*

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5

class Fragment_w3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_w3, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_lanjut.setOnClickListener {
            val intent = Intent(getActivity(),MainActivity::class.java)
            startActivity(intent)
        }
    }
}
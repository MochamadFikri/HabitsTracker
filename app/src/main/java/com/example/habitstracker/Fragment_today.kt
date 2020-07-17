package com.example.habitstracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_today.*
import java.text.SimpleDateFormat

class Fragment_today : Fragment() {

    val listHabits = listOf(
        Habits("HB099","Meminum Coklat Panas","19.00"),
        Habits("HB100","Bermain Tiktaktuk","20.00")
    )

    var currentDay : String = SimpleDateFormat("E", java.util.Locale.getDefault()).format(
        java.util.Date()
    )
    var tanggalSekarang: String = SimpleDateFormat("dd", java.util.Locale.getDefault()).format(
        java.util.Date()
    )
    var tahunSekarang: String = SimpleDateFormat("yyyy", java.util.Locale.getDefault()).format(
        java.util.Date()
    )
    var currentMonth: String = SimpleDateFormat("MM", java.util.Locale.getDefault()).format(
        java.util.Date()
    )
    lateinit var hariSekarang: String
    lateinit var bulanSekarang: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        cekHari()
        cekBulan()

        hari.setText(hariSekarang+",")
        tanggal.setText(tanggalSekarang+" "+bulanSekarang+" "+tahunSekarang)
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

    private fun cekHari(){
        if(currentDay == "mon"){
            hariSekarang = "Senin"
        }else if(currentDay == "tue"){
            hariSekarang = "Selasa"
        }else if(currentDay == "wed"){
            hariSekarang = "Rabu"
        }else if(currentDay == "thu"){
            hariSekarang = "Kamis"
        }else if(currentDay == "fri"){
            hariSekarang = "Jum'at"
        }else if(currentDay == "sat"){
            hariSekarang = "Sabtu"
        }else{
            hariSekarang = "Minggu"
        }
    }


    private fun cekBulan(){
        if(currentMonth == "01"){
            bulanSekarang = "Januari"
        }else if(currentMonth == "02"){
            bulanSekarang = "Februari"
        }else if(currentMonth == "03"){
            bulanSekarang = "Maret"
        }else if(currentMonth == "04"){
            bulanSekarang = "April"
        }else if(currentMonth == "05"){
            bulanSekarang = "Mei"
        }else if(currentMonth == "06"){
            bulanSekarang = "Juni"
        }else if(currentMonth == "07"){
            bulanSekarang = "Juli"
        }else if(currentMonth == "08"){
            bulanSekarang = "Agustus"
        }else if(currentMonth == "09"){
            bulanSekarang = "September"
        }else if(currentMonth == "10"){
            bulanSekarang = "Oktober"
        }else if(currentMonth == "11"){
            bulanSekarang = "November"
        }else{
            bulanSekarang = "Desember"
        }
    }
}
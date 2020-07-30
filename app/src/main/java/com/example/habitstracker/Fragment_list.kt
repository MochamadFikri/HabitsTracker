package com.mochamadfghd.habitstracker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import java.text.SimpleDateFormat
import java.util.*


class Fragment_list : Fragment(), HabitsListAdapter.onItemClickListener {


    private val newHabitsActivityRequestCode = 1
    private var updateHabitsActivityRequestCode = 2

    var currentDay : String = SimpleDateFormat("E", Locale.getDefault()).format(
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

    private lateinit var habitsViewModel: HabitsViewModel

    private var habits = listOf<Habits>()

    lateinit var mContext: Context


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cekBulan()
        cekHari()

        hari.setText(hariSekarang)
        tanggal.setText(tanggalSekarang + " " + bulanSekarang + " " + tahunSekarang)

        habitsViewModel = ViewModelProvider(this).get(HabitsViewModel::class.java)

        val adapter = HabitsListAdapter(mContext)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(mContext)
        habitsViewModel.allHabits.observe(viewLifecycleOwner, Observer { habits ->
            // Update the cached copy of the words in the adapter.
            habits?.let { adapter.setHabits(it,this)}
        })


        fab.setOnClickListener {
            val intent = Intent(mContext, HabitsAdd::class.java)
            startActivityForResult(intent, newHabitsActivityRequestCode)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var id_reply:String = data?.getStringExtra(HabitsAdd.ID_REPLY).toString()
        var nama_reply:String = data?.getStringExtra(HabitsAdd.NAMA_REPLY).toString()
        var waktu_reply:String = data?.getStringExtra(HabitsAdd.WAKTU_REPLY).toString()

        var delete = data?.getStringExtra(HabitsUpdate.DELETE_REPLY).toString()

        if (requestCode == newHabitsActivityRequestCode && resultCode == Activity.RESULT_OK) {
            let {
                val habits = Habits(id_reply,nama_reply,waktu_reply)
                habitsViewModel.insert(habits)
            }
        }else if (requestCode == updateHabitsActivityRequestCode && resultCode == Activity.RESULT_OK) {
            val habits = Habits(id_reply, nama_reply, waktu_reply)
            if(delete == "1") {
                let {
                    println("MASHUUUUUUUUUUK")
                    println(delete)
                    habitsViewModel.delete(habits)
                }
            }else{
                let {
                    println(delete)
                    println("ORA   MASHUUUUUUUUUUK")
                    habitsViewModel.update(habits)
                }
            }
        } else  {

        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object{
        fun newInstance(): Fragment_list = Fragment_list()
    }

    override fun itemClickListener(habits: Habits, position: Int) {
        val intent = Intent(activity,HabitsUpdate::class.java)
        intent.putExtra("ID_HABIT",habits.id)
        intent.putExtra("NAMA_HABIT",habits.nama)
        intent.putExtra("WAKTU_HABIT",habits.waktu)
        startActivityForResult(intent, updateHabitsActivityRequestCode)
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



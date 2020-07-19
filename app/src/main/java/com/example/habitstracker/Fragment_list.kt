package com.example.habitstracker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*


class Fragment_list : Fragment(), HabitsListAdapter.onItemClickListener {


    private val newHabitsActivityRequestCode = 1
    private val updateHabitsActivityRequestCode = 2
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

        var nama_reply:String = data?.getStringExtra(HabitsAdd.NAMA_REPLY).toString()
        var waktu_reply:String = data?.getStringExtra(HabitsAdd.WAKTU_REPLY).toString()
        var delete:String = data?.getStringExtra(HabitsUpdate.DELETE).toString()

        if ( delete == "1") {
            let {
                val habits = Habits(nama_reply,waktu_reply)
                habitsViewModel.delete(habits)
            }
        } else if (requestCode == updateHabitsActivityRequestCode && resultCode == Activity.RESULT_OK) {
            let {
                val habits = Habits(nama_reply,waktu_reply)
                habitsViewModel.update(habits)
            }
        } else if (requestCode == newHabitsActivityRequestCode && resultCode == Activity.RESULT_OK) {
            let {
                val habits = Habits(nama_reply,waktu_reply)
                habitsViewModel.insert(habits)
            }
        } else {
            Toast.makeText(
                mContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
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
        intent.putExtra("NAMA_HABIT",habits.nama)
        intent.putExtra("WAKTU_HABIT",habits.waktu)
        startActivityForResult(intent, updateHabitsActivityRequestCode)
    }
}



package com.example.habitstracker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_list.*


class Fragment_list : Fragment() {


    private val newWordActivityRequestCode = 1
    private lateinit var habitsViewModel: HabitsViewModel

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
        habitsViewModel.allHabits.observe(viewLifecycleOwner, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setHabits(it) }
        })


        fab.setOnClickListener {
            val intent = Intent(mContext, HabitsAdd::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var id_reply:String = data?.getStringExtra(HabitsAdd.ID_REPLY).toString()
        var nama_reply:String = data?.getStringExtra(HabitsAdd.NAMA_REPLY).toString()
        var waktu_reply:String = data?.getStringExtra(HabitsAdd.WAKTU_REPLY).toString()

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            let {
                val habits = Habits(id_reply,nama_reply,waktu_reply)
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
}



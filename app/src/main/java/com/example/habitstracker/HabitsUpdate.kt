package com.mochamadfghd.habitstracker

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType.TYPE_NULL
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class HabitsUpdate : AppCompatActivity() {

    private lateinit var editHabitsNama: EditText
    private lateinit var editHabitsWaktu: EditText
    private lateinit var editHabitsId: TextView
    private lateinit var button_pilih: Button
    private var delete: String = "1"



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habit_update)


        editHabitsNama = findViewById(R.id.habits_nama)
        editHabitsWaktu = findViewById(R.id.habits_waktu)
        editHabitsId = findViewById(R.id.idhab)
        button_pilih = findViewById(R.id.button_pilih)

        editHabitsId.setText(intent.getStringExtra("ID_HABIT").toString())
        editHabitsNama.setText(intent.getStringExtra("NAMA_HABIT").toString())
        editHabitsWaktu.setText(intent.getStringExtra("WAKTU_HABIT").toString())

        editHabitsWaktu.setInputType(TYPE_NULL)

        button_pilih.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                val timestamp = cal.timeInMillis / 1000
                editHabitsWaktu.setText(SimpleDateFormat("HH:mm").format(cal.time))
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

        }

        val button_save = findViewById<Button>(R.id.button_save)
        button_save.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(editHabitsNama.text) || TextUtils.isEmpty(editHabitsWaktu.text)) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val habitsId = editHabitsId.text.toString()
                val habitsNama = editHabitsNama.text.toString()
                val habitsWaktu = editHabitsWaktu.text.toString()
                delete = "0"
                intent.putExtra(ID_REPLY, habitsId)
                intent.putExtra(NAMA_REPLY, habitsNama)
                intent.putExtra(WAKTU_REPLY, habitsWaktu)
                intent.putExtra(DELETE_REPLY, delete)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }


        val button_delete = findViewById<Button>(R.id.button_delete)
        button_delete.setOnClickListener {
            val intent = Intent()

            val habitsId = editHabitsId.text.toString()
            val habitsNama = editHabitsNama.text.toString()
            val habitsWaktu = editHabitsWaktu.text.toString()
            delete = "1"

            intent.putExtra(ID_REPLY, habitsId)
            intent.putExtra(NAMA_REPLY, habitsNama)
            intent.putExtra(WAKTU_REPLY, habitsWaktu)
            intent.putExtra(DELETE_REPLY, delete)
            setResult(Activity.RESULT_OK, intent)

            finish()
        }

        val button_cancel = findViewById<Button>(R.id.button_cancel)
        button_cancel.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val ID_REPLY = "com.example.android.habitslistsql.ID"
        const val NAMA_REPLY = "com.example.android.habitslistsql.NAMA"
        const val WAKTU_REPLY = "com.example.android.habitslistsql.WAKTU"
        const val DELETE_REPLY = "com.example.android.habitslistsql.DELETE"
    }
}
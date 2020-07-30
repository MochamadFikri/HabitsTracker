package com.mochamadfghd.habitstracker

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType.TYPE_NULL
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class HabitsAdd : AppCompatActivity() {

    private lateinit var editHabitsNama: EditText
    private lateinit var editHabitsWaktu: EditText
    private lateinit var button_pilih: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habit_add)

        editHabitsNama = findViewById(R.id.habits_nama)
        editHabitsWaktu = findViewById(R.id.habits_waktu)
        button_pilih = findViewById(R.id.button_pilih)

        editHabitsWaktu.setInputType(TYPE_NULL)

        button_pilih.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
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
                val habitsId = Calendar.getInstance().timeInMillis.toString()
                val habitsNama = editHabitsNama.text.toString()
                val habitsWaktu = editHabitsWaktu.text.toString()
                intent.putExtra(ID_REPLY, habitsId)
                intent.putExtra(NAMA_REPLY, habitsNama)
                intent.putExtra(WAKTU_REPLY, habitsWaktu)
                setResult(Activity.RESULT_OK, intent)
            }
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
    }
}
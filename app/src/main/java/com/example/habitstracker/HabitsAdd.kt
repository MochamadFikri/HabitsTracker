package com.example.habitstracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class HabitsAdd : AppCompatActivity() {

    private lateinit var editHabitsId: EditText
    private lateinit var editHabitsNama: EditText
    private lateinit var editHabitsWaktu: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habit_add)
        editHabitsId = findViewById(R.id.habits_id)
        editHabitsNama = findViewById(R.id.habits_nama)
        editHabitsWaktu = findViewById(R.id.habits_waktu)


        val button_save = findViewById<Button>(R.id.button_save)
        button_save.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(editHabitsId.text) || TextUtils.isEmpty(editHabitsNama.text) || TextUtils.isEmpty(editHabitsWaktu.text)) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val habitsId = editHabitsId.text.toString()
                val habitsNama = editHabitsNama.text.toString()
                val habitsWaktu = editHabitsWaktu.text.toString()
                intent.putExtra(ID_REPLY, habitsId)
                intent.putExtra(NAMA_REPLY, habitsNama)
                intent.putExtra(WAKTU_REPLY, habitsWaktu)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }


        val button_cancel = findViewById<Button>(R.id.button_save)
        button_cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, intent)
        }
    }

    companion object {
        const val ID_REPLY = "com.example.android.habitslistsql.ID"
        const val NAMA_REPLY = "com.example.android.habitslistsql.NAMA"
        const val WAKTU_REPLY = "com.example.android.habitslistsql.WAKTU"
    }
}
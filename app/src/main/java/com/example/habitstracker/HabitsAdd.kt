package com.example.habitstracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HabitsAdd : AppCompatActivity() {

    private lateinit var editHabitsView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.habit_add)
        editHabitsView = findViewById(R.id.habits_nama)


        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(editHabitsView.text)) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val habits = editHabitsView.text.toString()
                intent.putExtra(EXTRA_REPLY, habits)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.habitslistsql.REPLY"
    }
}
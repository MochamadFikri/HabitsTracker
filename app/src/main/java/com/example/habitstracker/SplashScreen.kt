package com.example.habitstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila AKbar
// Kelas : IF-5

// Tanggal Pengerjaan
// 27 Juni 2020 : Pembuatan Splash Screen

class SplashScreen : AppCompatActivity() {

    lateinit var handler:Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashScreen,Walkthrough::class.java)
            startActivity(intent)
            finish()
        },3000)
    }

}
package com.mochamadfghd.habitstracker

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5

class SplashScreen : AppCompatActivity() {

    lateinit var handler:Handler

    private lateinit var mSharedPreferences: SharedPreferences
    private var MODE_PRIVATE = 0
    private var PREF_NAME = "splash-screen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        mSharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        handler = Handler()
        handler.postDelayed({
                val status = mSharedPreferences.getBoolean(PREF_NAME,false)
                if(status == false){

                    PREF_NAME = "splash-screen"
                    val editor = mSharedPreferences.edit()
                    editor.putBoolean(PREF_NAME, true)
                    editor.apply()

                    val intent = Intent(this@SplashScreen,Walkthrough::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    val intent = Intent(this@SplashScreen,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
        },3000)
    }
}
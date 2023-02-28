package com.riyandifirman.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    // Deklarasi companion object untuk menampung key dan value
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    // Method onCreate() untuk menampilkan data yang dikirimkan dari MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        // Mencari view dengan id tv_data_received
        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        // Membuat variabel name dan age untuk menampung data yang dikirimkan dari MainActivity
        // dengan key EXTRA_NAME dan EXTRA_AGE default value 0
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        // Menampilkan data yang dikirimkan dari MainActivity ke TextView
        val text = "Name: $name, Your age: $age"
        tvDataReceived.text = text
    }
}
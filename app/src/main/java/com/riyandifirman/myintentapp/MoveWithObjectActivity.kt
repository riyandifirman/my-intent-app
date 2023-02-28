package com.riyandifirman.myintentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        // Mencari view dengan id tv_object_received
        val tvObjectReceived: TextView = findViewById(R.id.tv_object_received)

        // Membuat variabel person untuk menampung data yang dikirimkan dari MainActivity
        // dengan key EXTRA_PERSON
        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        // Menampilkan data yang dikirimkan dari MainActivity ke TextView
        if (person != null) {
            val text = "Name : ${person.name.toString()},\nEmail : ${person.email}, \nAge : ${person.age}, \nLocation : ${person.city}"
            tvObjectReceived.text = text
        }
    }
}
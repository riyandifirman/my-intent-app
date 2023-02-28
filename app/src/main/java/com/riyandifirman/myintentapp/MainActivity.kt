package com.riyandifirman.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisisasi button dengan id btn_move_activity
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        // Inisisasi button dengan id btn_move_activity_data
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        // Inisisasi button dengan id btn_move_activity_object
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                // Intent tanpa membawa data
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                // Intent dengan membawa data
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                // Memasukkan data ke intent dengan key EXTRA_NAME dan value "Riyandi Firman"
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Riyandi Firman")
                // Memasukkan data ke intent dengan key Extra_AGE dan value 20
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_object -> {
                // Intent dengan membawa data berupa object
                val person = Person(
                    "Riyandi Firman",
                    20,
                    "riyandi.firman08@gmail.com",
                    "Bandung"
                )
                // Intent dengan membawa data berupa object
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                // Memasukkan data ke intent dengan key EXTRA_PERSON dan value person
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
        }
    }
}
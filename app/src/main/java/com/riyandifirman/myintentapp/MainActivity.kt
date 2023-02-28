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

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)
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
        }
    }
}
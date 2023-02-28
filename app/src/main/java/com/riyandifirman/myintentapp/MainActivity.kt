package com.riyandifirman.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Deklarasi variabel
    private lateinit var tvResult: TextView

    // Membuat variabel resultLauncher untuk menampung hasil dari activity MoveForResultActivity
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result -> // result adalah hasil dari activity MoveForResultActivity
        // Jika result.resultCode sama dengan MoveForResultActivity.RESULT_CODE
        if (result.resultCode == MoveForResultActivity.RESULT_CODE) {
            // Membuat variabel selectedValue untuk menampung data yang dikirimkan dari MoveForResultActivity
            val selectedValue = result.data?.getIntExtra(
                // Key dari data yang dikirimkan dari MoveForResultActivity
                MoveForResultActivity.EXTRA_SELECTED_VALUE, 0
            )
            // Menampilkan data yang dikirimkan dari MoveForResultActivity ke TextView
            tvResult.text = "Hasil: $selectedValue"
        }
    }

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

        // Inisisasi button dengan id btn_dial_number
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
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

            R.id.btn_dial_number -> {
                val phoneNumber = "08123456789"
                // Intent untuk melakukan panggilan telepon
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                // Intent untuk membuka activity MoveForResultActivity
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                // Memulai activity MoveForResultActivity dan menunggu hasilnya
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}
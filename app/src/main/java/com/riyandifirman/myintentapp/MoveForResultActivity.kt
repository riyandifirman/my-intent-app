package com.riyandifirman.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    // Deklarasi companion object untuk menampung key dan value
    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        // Mencari view dengan id btn_choose dan rg_number
        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // Jika view yang diklik adalah btn_choose dan rg_number memiliki radio button yang dipilih > 0
        if (v?.id == R.id.btn_choose) {
            if (rgNumber.checkedRadioButtonId > 0) {
                // Membuat variabel value untuk menampung nilai dari radio button yang dipilih
                var value = 0
                when (rgNumber.checkedRadioButtonId) {
                    // Jika radio button yang dipilih adalah rb_50 maka value = 50
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }

                // Membuat intent untuk menampung data yang akan dikirimkan ke MainActivity
                val resultIntent = Intent()
                // Menambahkan data dengan key EXTRA_SELECTED_VALUE dan value
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                // Mengirimkan data ke MainActivity dengan setResult()
                setResult(RESULT_CODE, resultIntent)
                // Menutup activity MoveForResultActivity
                finish()
            }
        }
    }
}
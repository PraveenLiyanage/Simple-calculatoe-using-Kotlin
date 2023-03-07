package com.example.madtute3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.madtute3.models.Calculator

lateinit var edtNumber1:EditText
lateinit var edtNumber2:EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.editNumber1)
        edtNumber2 = findViewById(R.id.editNumber2)
    }

    fun buttonClick(v: View) {
        var ans = 0.0
        val calculator = Calculator.Calculator(
            edtNumber1.text.toString().toDouble(),
            edtNumber2.text.toString().toDouble()
        )
        when (v.id) {
            R.id.btnPlus -> ans = calculator.add()
            R.id.btnMinus -> ans = calculator.subtract()
            R.id.btnMultiply -> ans = calculator.multiply()
            R.id.btnDivide -> ans = calculator.divide()
        }
        println(ans)//this will print the output on the terminal

        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
        finish()
    }
}
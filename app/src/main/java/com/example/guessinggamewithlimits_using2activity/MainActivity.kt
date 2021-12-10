package com.example.guessinggamewithlimits_using2activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var secretInputValue = findViewById<EditText>(R.id.Secretvalue)
        var guessInputValue = findViewById<TextInputLayout>(R.id.guessvalue)
        val clickMeButton = findViewById<TextView>(R.id.clickme)
        val viewResult = findViewById<TextView>(R.id.display_op)
        var count = 0

        clickMeButton.setOnClickListener {
            val newScreenIntend = Intent(this, EndGameActivity::class.java)

            count++

            if(secretInputValue.text.toString().toInt() == guessInputValue .editText?.text.toString().toInt()!! && count<=12)
            {
                newScreenIntend.putExtra("result", "True")
                newScreenIntend.putExtra("number", secretInputValue.text.toString())
                startActivity(newScreenIntend)
                count = 0
            }
            else if(secretInputValue.text.toString().toInt() != guessInputValue .editText?.text.toString().toInt()!! && count==12)
            {
                newScreenIntend.putExtra("result", "False")
                newScreenIntend.putExtra("number", secretInputValue.text.toString())
                startActivity(newScreenIntend)
                count = 0
            }
            else
            {
              val maskedValue=
                  if(secretInputValue.text.toString().toInt() > guessInputValue .editText?.text.toString().toInt()!!) "No :) My number is bigger"
                 else "No :) My number is smaller"
               viewResult.text = "$maskedValue"
            }
        }
    }
}
package com.example.guessinggamewithlimits_using2activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)
        val Value = intent.getStringExtra("result")
        val Number = intent.getStringExtra("number")
        if( Value=="False")
        {
            findViewById<TextView>(R.id.number).setTextColor(Color.RED)
            findViewById<TextView>(R.id.number).text = "$Number"
            findViewById<TextView>(R.id.mymessage).text = "You Lost After 12 attempts. \nThe number is"
        }
        else if( Value=="True")
        {
            findViewById<TextView>(R.id.number).setTextColor(Color.GREEN)
            findViewById<TextView>(R.id.number).text = "$Number"
            findViewById<TextView>(R.id.mymessage).text = "You Won! The Number is"
        }
    }
}
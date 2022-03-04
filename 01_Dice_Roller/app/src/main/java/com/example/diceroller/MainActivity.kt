package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val numSides = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val resultTextView: TextView = findViewById(R.id.textView)

        // When the Roll button is clicked, display the dice value in the TextView
        rollButton.setOnClickListener {
            resultTextView.text = rollDice(numSides)
        }
    }

    private fun rollDice(sides: Int): String = Dice(sides).roll().toString()
}
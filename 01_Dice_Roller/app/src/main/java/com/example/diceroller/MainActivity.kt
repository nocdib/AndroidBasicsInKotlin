package com.example.diceroller

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val numSides = 6


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButtonClick()

        // When the Roll button is clicked, display the dice value in the TextView
        rollButton.setOnClickListener {
            rollButtonClick()
        }
    }

    fun rollButtonClick() {
        var content = rollDice()
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(content)
        diceImage.contentDescription = content.toString()
    }

    private fun rollDice(): Int {
        val drawable = when(Dice(numSides).roll()) {
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
        return drawable
    }
}
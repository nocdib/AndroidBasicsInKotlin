package com.example.diceroller

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun dice_roll_value() {
        val dice = Dice()
        var rollValue = dice.roll()
        assertTrue("Dice value (${rollValue}) is not between 1 and ${dice.sides}", rollValue in 1..dice.sides)
    }

}
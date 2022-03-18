package com.nocdib.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.division_textview).setText("Hello, debugging!")
        //division()
    }

    fun logging(){
        Log.v(TAG, "This is Log.v()")
        Log.d(TAG, "This is Log.d()")
        Log.e(TAG, "This is Log.e()")
        Log.i(TAG, "This is Log.i()")
        Log.w(TAG, "This is Log.w()")
        Log.wtf(TAG, "This is Log.wtf()")
    }

    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(4) {
            Thread.sleep(5000)
            var equation = numerator / denominator
            findViewById<TextView>(R.id.division_textview).setText("${equation}")
            Log.v(TAG, "${equation}")
            denominator--
        }
    }
}
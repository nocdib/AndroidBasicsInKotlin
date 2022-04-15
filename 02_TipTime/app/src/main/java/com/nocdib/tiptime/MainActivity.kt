package com.nocdib.tiptime

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {

    private var calculateButton: Button? = null
    private var tipResult: TextView? = null
    private var costOfService: EditText? = null
    private var roundUpSwitch: Switch? = null
    private var tipPercentage: Double = 0.2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton = findViewById(R.id.calculate_button)
        tipResult = findViewById(R.id.tip_result)
        costOfService = findViewById(R.id.cost_of_service)
        roundUpSwitch = findViewById(R.id.round_up_switch)

        calculateButton!!.isEnabled = false

        costOfService!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var cost = costOfService!!.getText().toString().toDoubleOrNull()
                if (cost == null) {
                    calculateButton!!.isEnabled = false
                    tipResult!!.setText(resources.getString(R.string.tip_amount))
                } else {
                    calculateButton!!.isEnabled = true
                }
            }
        })

        calculateButton!!.setOnClickListener {
            closeKeyboard()
            var cost = costOfService!!.getText().toString().toDouble()
            var tipAmount = BigDecimal(cost * tipPercentage).setScale(2, roundingMethod()).toString()
            /* Snackbar.make(
                findViewById(R.id.constraint_layout),
                roundingMethod().toString(),
                Snackbar.LENGTH_SHORT
            ).show() */
            tipResult!!.setText("$" + tipAmount)
        }

    }

    private fun roundingMethod(): RoundingMode =
        if (roundUpSwitch!!.isChecked) {
            RoundingMode.UP
        } else {
            RoundingMode.DOWN
        }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.option_twenty_percent ->
                    if (checked) {
                        tipPercentage = 0.2
                    }
                R.id.option_eighteen_percent ->
                    if (checked) {
                        tipPercentage = 0.18
                    }
                R.id.option_fifteen_percent ->
                    if (checked) {
                        tipPercentage = 0.15
                    }
            }
        }
    }

    private fun closeKeyboard() {
        // this will give us the view which is currently focus in this layout
        val view: View? = this.currentFocus

        // if nothing is currently focus then this will protect the app from crash
        if (view != null) {
            // now assign the system service to InputMethodManager
            val manager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }
    }
    
}
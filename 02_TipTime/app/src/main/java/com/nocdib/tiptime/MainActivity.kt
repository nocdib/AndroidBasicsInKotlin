package com.nocdib.tiptime

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*
import com.nocdib.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var calculateButton: Button? = null
    private var tipResult: TextView? = null
    private var costOfService: TextInputEditText? = null
    private var roundUpSwitch: SwitchMaterial? = null
    private var tipPercentage: Double = 0.2

    // Binding object instance with access to the views in the activity_main.xml layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout XML file and return a binding object instance
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the content view of the Activity to be the root view of the layout
        setContentView(binding.root)

        // Setup a click listener on the calculate button to calculate the tip
        binding.calculateButton.setOnClickListener {
            closeKeyboard()
            val stringInTextField = binding.costOfServiceEditText.text.toString()
            var cost = stringInTextField.toDouble()
            var tipAmount = NumberFormat.getCurrencyInstance(Locale("en", "US")).format(cost * tipPercentage)
            val totalAmount = NumberFormat.getCurrencyInstance(Locale("en", "US")).format(cost * (1 + tipPercentage) )
            /* Snackbar.make(
                findViewById(R.id.constraint_layout),
                roundingMethod().toString(),
                Snackbar.LENGTH_SHORT
            ).show() */
            tipResult!!.setText("${tipAmount} (${totalAmount})")
        }


        calculateButton = findViewById(R.id.calculate_button)
        tipResult = findViewById(R.id.tip_result)
        costOfService = findViewById(R.id.cost_of_service_edit_text)
        roundUpSwitch = findViewById(R.id.round_up_switch)

        calculateButton!!.isEnabled = false

        costOfService!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var cost = binding.costOfServiceEditText.text.toString().toDoubleOrNull()
                if (cost == null) {
                    calculateButton!!.isEnabled = false
                    tipResult!!.setText(resources.getString(R.string.tip_amount))
                } else {
                    calculateButton!!.isEnabled = true
                }
            }
        })

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
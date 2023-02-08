package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var lastNumber: Boolean = false
    var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }

    fun onClickDigit(view: View) {
        binding.processCalc?.append((view as Button).text)
        lastDot = false
        lastNumber = true
        Toast.makeText(this, "clicou", Toast.LENGTH_LONG).show()

    }

    fun onClear(view: View) {
        binding.processCalc?.text = ""
    }

    fun onAllClear(view: View) {
        onClear(view)
        binding.calcResult?.text = ""
    }

    fun onDot(view: View) {
        if (lastNumber && !lastDot) {
            binding.processCalc?.append(".")
            lastDot = true
            lastNumber = false
        }

    }

    fun onEquals(view: View) {
        var tvValueString = binding.processCalc?.text.toString()
        var resultSplits : Double? = null


        try {
            var prefix = ""
            var firstValueSplited : String? = null
            var secondValueSplited: String? = null

            if (tvValueString.startsWith("-")){
                prefix = "-"
                tvValueString.substring(1)
            }
            if (tvValueString.contains("-")) {
                var valueSplited = tvValueString.split("-")
                 firstValueSplited = valueSplited[0]
                 secondValueSplited = valueSplited[1]

                if (prefix.isNotEmpty()) {
                    firstValueSplited = prefix + firstValueSplited
                }

                resultSplits = firstValueSplited.toDouble() - secondValueSplited.toDouble()
            } else if (tvValueString.contains("+")) {
                var valueSplited = tvValueString.split("+")
                firstValueSplited = valueSplited[0]
                secondValueSplited = valueSplited[1]

                if (prefix.isNotEmpty()) {
                    firstValueSplited = prefix + firstValueSplited
                }

                resultSplits = firstValueSplited.toDouble() + secondValueSplited.toDouble()
            } else if (tvValueString.contains("/")) {
                var valueSplited = tvValueString.split("/")
                firstValueSplited = valueSplited[0]
                secondValueSplited = valueSplited[1]

                if (prefix.isNotEmpty()) {
                    firstValueSplited = prefix + firstValueSplited
                }

                resultSplits = firstValueSplited.toDouble() / secondValueSplited.toDouble()
            } else if (tvValueString.contains("x")) {
                var valueSplited = tvValueString.split("x")
                firstValueSplited = valueSplited[0]
                secondValueSplited = valueSplited[1]

                if (prefix.isNotEmpty()) {
                    firstValueSplited = prefix + firstValueSplited
                }

                resultSplits = firstValueSplited.toDouble() * secondValueSplited.toDouble()
            }

            binding.calcResult?.text = tvValueString
            binding.processCalc?.text = resultSplits?.toString()



        }catch (e: java.lang.ArithmeticException) {
            e.printStackTrace()
        }
    }

    fun onOperator(view: View) {
        binding.processCalc?.text?.let {
            if (lastNumber && !insOperatorIsAdded(it.toString())) {
                binding.processCalc?.append((view as Button).text)
                lastDot = false
                lastNumber = false
            }
        }
    }

    fun insOperatorIsAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") ||
                    value.contains("*") ||
                    value.contains("+") ||
                    value.contains("-")
        }
    }

}
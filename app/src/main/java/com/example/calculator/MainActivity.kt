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
    lateinit var binding : ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)


    }
            fun onClickDigit(view: View){
                binding.processCalc?.append((view as Button).text)
                Toast.makeText(this, "clicou", Toast.LENGTH_LONG).show()

                }

            fun onClear(view: View) {
                binding.processCalc?.text = ""
            }   fun onAllClear(view: View) {
                onClear(view)
                binding.calcResult?.text = ""
            }

}
package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val calcClick = CalculateClickListener()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)

            binding.number0.setOnClickListener {
            Toast.makeText(this,"sera q foi", Toast.LENGTH_LONG).show()

        }


    }



}
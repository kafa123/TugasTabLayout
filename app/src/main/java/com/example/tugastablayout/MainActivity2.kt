package com.example.tugastablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugastablayout.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            binding.btn.setOnClickListener {
                val intent= Intent(this@MainActivity2,MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}
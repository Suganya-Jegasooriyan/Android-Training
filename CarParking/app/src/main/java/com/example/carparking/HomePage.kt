package com.example.carparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)
        initView()
    }

    private fun initView() {
        val checkInIc = findViewById<FloatingActionButton>(R.id.ic_check_in)
        checkInIc.setOnClickListener {
            val intent = Intent(this, CarDetails::class.java)
            startActivity(intent)
        }
    }
}
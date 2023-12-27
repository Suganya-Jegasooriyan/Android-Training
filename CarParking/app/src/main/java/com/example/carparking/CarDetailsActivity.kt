package com.example.carparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CarDetailsActivity : AppCompatActivity() {
    private lateinit var tilCarNumber : TextInputLayout
    private lateinit var etCarNumber : TextInputEditText
    private lateinit var tilMobileNumber : TextInputLayout
    private lateinit var etMobileNumber : TextInputEditText
    private lateinit var btnCheckIn : Button
    private var isAllFieldsChecked : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)
        initView()
    }

    private fun initView() {
        val toolbar: Toolbar = findViewById(R.id.carDetail_TitleBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tilCarNumber = findViewById(R.id.tilCarNumber)
        etCarNumber = findViewById(R.id.etCarNumber)
        tilMobileNumber = findViewById(R.id.tilMobileNumber)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        btnCheckIn = findViewById(R.id.Check_In_Button)
        displayDetails()
    }

    private fun displayDetails() {
        btnCheckIn.setOnClickListener {
            val carNumber = etCarNumber.text.toString()
            val mobileNumber = etMobileNumber.text.toString()
            isAllFieldsChecked = CheckAllFields(carNumber,mobileNumber)
            val intent = Intent()
            if(isAllFieldsChecked) {
                intent.putExtra("car_no", carNumber)
                intent.putExtra("mobile_no", mobileNumber)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun CheckAllFields(carNumber : String, mobileNumber : String) : Boolean {

        if(carNumber.isEmpty()) {
            tilCarNumber.error = "car number required"
            return false
        }
        if(mobileNumber.isEmpty()) {
            tilMobileNumber.error = "mobile number required"
            return false
        }
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
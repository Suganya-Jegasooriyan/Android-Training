package com.example.carparking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarParkingAdapter(val carParkingInterface: CarParkingInterface) : RecyclerView.Adapter<CarParkingAdapter.ViewHolder>(){
    private val carDetailList = mutableListOf<Car>()

    fun addCarDetails(carDetails: Car) {
        carDetailList.add(carDetails)
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvCarNumber: TextView = view.findViewById(R.id.show_car_number)
        val tvMobileNumber: TextView = view.findViewById(R.id.show_mobile_number)
        val btnCheckOut: Button = view.findViewById(R.id.check_out_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.detail_display, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carDetailList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carDetails: Car = carDetailList[position]
        holder.tvCarNumber.text = carDetails.carNumber
        holder.tvMobileNumber.text = carDetails.mobileNumber
        holder.btnCheckOut.setOnClickListener {
            carParkingInterface.onClick(carDetailList[position])
        }
    }
}

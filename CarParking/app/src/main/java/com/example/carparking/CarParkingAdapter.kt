package com.example.carparking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarParkingAdapter : RecyclerView.Adapter<CarParkingAdapter.ViewHolder>(){
    private val carDetailList = mutableListOf<Car>()
    fun addCarDetails(carDetails: Car) {
        carDetailList.add(carDetails)
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvCarNumber: TextView = view.findViewById(R.id.show_car_number)
        val tvMobileNumber: TextView = view.findViewById(R.id.show_mobile_number)
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
    }
}

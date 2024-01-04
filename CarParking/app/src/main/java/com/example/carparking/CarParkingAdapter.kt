package com.example.carparking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarParkingAdapter(private val carParkingInterface: CarParkingInterface) : RecyclerView.Adapter<CarParkingAdapter.ViewHolder>(){

    private val carDetailList = mutableListOf<Car>()

    fun addCarDetails(carDetails: Car) {
        val nax = getNextAvailableSlot()
        if(nax == -1) {
            carDetails.slotNumber = carDetailList.size + 1
        }
        else {
            carDetails.slotNumber = nax
        }
        carDetailList.add(carDetails)
        notifyDataSetChanged()
    }

    private fun getNextAvailableSlot(): Int {
        for(i in 0..carDetailList.size) {
            val obj = carDetailList[i]
            val position = i + 1
           return if(position != obj.slotNumber){
                return position
            }
            else -1
        }
        return -1
    }

    fun removeCar(car: Car) {
        val index = carDetailList.indexOf(car)
        carDetailList.removeAt(index)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvCarNumber: TextView = view.findViewById(R.id.show_car_number)
        val tvMobileNumber: TextView = view.findViewById(R.id.show_mobile_number)
        val tvSlotNumber : TextView = view.findViewById(R.id.show_slot_number)
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
        holder.tvSlotNumber.text = carDetails.slotNumber.toString()
        holder.btnCheckOut.setOnClickListener {
            carParkingInterface.onClick(carDetails)
        }
    }
}

package com.example.carparking


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class CheckOutDialogFragment : DialogFragment() {
    private lateinit var tvCarNumber : TextView
    private lateinit var tvMobileNumber : TextView
    private lateinit var tvSlotNumber : TextView
    private lateinit var tvCheckIn : TextView
    private lateinit var tvCheckOut : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.check_out_page, container, false)
        tvCarNumber = view.findViewById<View>(R.id.check_out_car_number) as TextView
        tvMobileNumber = view.findViewById<View>(R.id.check_out_mobile_number) as TextView
        tvSlotNumber = view.findViewById<View>(R.id.check_out_slot_number) as TextView
        tvCheckIn = view.findViewById<View>(R.id.in_time) as TextView
        tvCheckOut = view.findViewById<View>(R.id.check_out_amount) as TextView
        val bundle = arguments?.getParcelable<Car>("carDetails")
        if (bundle != null) {
            tvCarNumber.text = bundle.carNumber
            tvMobileNumber.text = bundle.mobileNumber
        }
        return view
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(600, 800)
    }
}
package com.example.carparking


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.Locale

class CheckOutDialogFragment : DialogFragment() {
    private lateinit var tvCarNumber : TextView
    private lateinit var tvMobileNumber : TextView
    private lateinit var tvSlotNumber : TextView
    private lateinit var tvCheckIn : TextView
    private lateinit var tvCheckOutAmount : TextView
    private lateinit var btnOK : Button
    private var checkInTime: Long = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.check_out_dialog, container, false)
        tvCarNumber = view.findViewById<View>(R.id.check_out_car_number) as TextView
        tvMobileNumber = view.findViewById<View>(R.id.check_out_mobile_number) as TextView
        tvSlotNumber = view.findViewById<View>(R.id.check_out_slot_number) as TextView
        tvCheckIn = view.findViewById<View>(R.id.in_time) as TextView
        tvCheckOutAmount = view.findViewById<View>(R.id.check_out_amount) as TextView
        btnOK = view.findViewById(R.id.check_out_ok_button) as Button
        btnOK.setOnClickListener {
                dismiss()
        }
        val bundle = arguments?.getParcelable<Car>(Constants.carDetails)
        if (bundle != null) {
            tvCarNumber.text = bundle.carNumber
            tvMobileNumber.text = bundle.mobileNumber
            tvSlotNumber.text = bundle.slotNumber.toString()
            tvCheckOutAmount.text = calculate().toString()
            val checkInTime = bundle.checkIn
            val date = changeSimpleDateFormat(bundle.checkIn)
            tvCheckIn.text = date
        }
        return view
    }

    private fun calculate(): Int {
     val amount = 50
        val timeDifference= System.currentTimeMillis() - checkInTime
        val timeDuration = timeDifference/(1000 * 60)
        val date = convertInHours(timeDuration)
        return amount * date.toInt()
    }

    private fun convertInHours(dateTime: Long) : String {
        val date = SimpleDateFormat(Constants.dateInHourFormat, Locale.getDefault())
        return date.format(dateTime)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(700, 900)
    }
    private fun changeSimpleDateFormat(checkIn: Long?) : String {
        val date = SimpleDateFormat(Constants.dateFormat, Locale.getDefault())
        return date.format(checkIn)
    }
}
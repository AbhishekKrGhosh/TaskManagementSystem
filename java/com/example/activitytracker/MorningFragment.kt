package com.example.activitytracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activitytracker.databinding.ActivityMainBinding


class MorningFragment: Fragment() {
    lateinit var v: View
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {
        v = inflater.inflate(R.layout.fragment_morning,container,false)


        return  v

    }
}/*
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import java.util.*

class MorningFragment : Fragment() {

    private lateinit var alarmMgr: AlarmManager
    private lateinit var alarmIntent: PendingIntent

    lateinit var view: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {
        view = inflater.inflate(R.layout.fragment_morning,container,false)
        return  view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alarmMgr = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(requireContext(), AlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(requireContext(), 0, intent, 0)
        }

        // Set alarm when user clicks the button
        val btnSetAlarm = view.findViewById<Button>(R.id.setAlarm)
        val btnCancelAlarm = view.findViewById<Button>(R.id.cancel)
        btnSetAlarm.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _: TimePicker, hourOfDay: Int, minute: Int ->
                    // Set the alarm time
                    calendar.apply {
                        timeInMillis = System.currentTimeMillis()
                        set(Calendar.HOUR_OF_DAY, hourOfDay)
                        set(Calendar.MINUTE, minute)
                    }
                    // Set the alarm using AlarmManager
                    alarmMgr.set(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        alarmIntent
                    )
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
            )
            timePickerDialog.show()
        }

        // Cancel alarm when user clicks the button
        btnCancelAlarm.setOnClickListener {
            alarmMgr.cancel(alarmIntent)
        }
    }


}
*/
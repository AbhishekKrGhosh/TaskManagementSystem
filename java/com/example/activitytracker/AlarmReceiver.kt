package com.example.activitytracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // Play the default ringtone
        val ringtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtonePlayer = RingtoneManager.getRingtone(context, ringtone)
        ringtonePlayer.play()

        // Show a toast message
        Toast.makeText(context, "Alarm ringing!", Toast.LENGTH_SHORT).show()
    }

}

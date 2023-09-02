package com.example.activitytracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ClassesFragment: Fragment() {
    lateinit var v: View

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {
        v = inflater.inflate(R.layout.fragment_classes,container,false)


        return  v

    }
}
package com.example.activitytracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ExpensesFragment: Fragment() {
    lateinit var v: View

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {
        v = inflater.inflate(R.layout.fragment_expenses,container,false)


        return  v

    }
}
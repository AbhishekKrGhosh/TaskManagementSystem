package com.example.activitytracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import java.io.File


class StudyFragment: Fragment() {
    lateinit var v: View

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?  ): View? {
        v = inflater.inflate(R.layout.fragment_study,container,false)

        val btn = v.findViewById<Button>(R.id.btnadd)
        val et1 = v.findViewById<EditText>(R.id.sub)

        btn.setOnClickListener {
            val fileName = et1.text.toString()
            val file = File(requireContext().filesDir, fileName)
            file.writeText(fileName)
            refreshFragment()
        }
        val listView = v.findViewById(R.id.list) as ListView
        val fileNames = getFileNames()
        fileNames.reverse()
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            fileNames
        )
        listView.adapter = adapter


        return  v

    }
    private fun getFileNames(): ArrayList<String> {
        val fileNames = ArrayList<String>()
        val filesDir = requireContext().filesDir
        for (file in filesDir.listFiles()) {
            val abc =file.toString()
            if(abc.contains("rList")|| abc.contains("users")){
                continue
            }
            fileNames.add(file.name)
//               Log.d(ContentValues.TAG, "hello: $file[0] " + "$file[1] ")
        }
        return fileNames
    }
    fun refreshFragment() {
        val fragment = StudyFragment()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

}
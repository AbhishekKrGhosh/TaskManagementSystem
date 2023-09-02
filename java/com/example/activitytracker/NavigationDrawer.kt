package com.example.activitytracker

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.google.android.material.navigation.NavigationView


class NavigationDrawer : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{
    lateinit var  drawer: DrawerLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        var toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        var actionBarDrawerToggle = ActionBarDrawerToggle(this,drawer,toolbar,
            R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MorningFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_morning)

        }

    }
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {

            R.id.nav_morning -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,MorningFragment())
                .commit()
            R.id.nav_study -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,StudyFragment())
                .commit()
            R.id.nav_fitness -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FitnessFragment())
                .commit()
            R.id.nav_classes -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ClassesFragment())
                .commit()
            R.id.nav_expenses -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ExpensesFragment())
                .commit()
            R.id.nav_exams -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ExamsFragment())
                .commit()
            R.id.nav_drives -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,PlacementDriveFragment())
                .commit()
            R.id.nav_contests -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ContestsFragment())
                .commit()
            R.id.nav_develop -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,DevelopFragment())
                .commit()
            R.id.nav_eat -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,EatFragment())
                .commit()
            R.id.nav_night -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,NightFragment())
                .commit()
            R.id.nav_others -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,OthersFragment())
                .commit()

            R.id.nav_share -> Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()

        }
        if(item.itemId == R.id.nav_logout){
            val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this@NavigationDrawer, SignUp::class.java)
            finish()
            startActivity(intent)
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show()
            return true
        }

        if(item.itemId == R.id.nav_share){

            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, "https://tinyurl.com/LMSinAndroid")
            startActivity(Intent.createChooser(share, " Download this "))
        }

        /*if(item.itemId == R.id.nav_report){

            val intent = Intent(this@NavigationDrawer, RateUs::class.java)
            finish()
            startActivity(intent)

            return true
        }*/
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


}
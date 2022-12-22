package com.example.healthcare

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Homepage : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        val drawerLayout: DrawerLayout = findViewById(R.id.draw)
        val navView: NavigationView = findViewById(R.id.nav)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent1= Intent(this,Food::class.java)
        val intent2= Intent(this,Excersixes::class.java)
        val intent3= Intent(this,MainActivity::class.java)
        val intent4=Intent(this,Appointment::class.java)
        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.food->startActivity(intent1)
                R.id.excer->startActivity(intent2)
                R.id.Cal->startActivity(intent3)
                R.id.appoint->startActivity(intent4)

            }
            true

        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }

}
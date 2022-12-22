package com.example.healthcare

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View.inflate
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val h = findViewById<EditText>(R.id.editTextNumber)
        val w = findViewById<EditText>(R.id.editTextNumber2)
        val test = findViewById<Button>(R.id.button)
        val cle=findViewById<Button>(R.id.clear)
        val resuld=findViewById<TextView>(R.id.textView4)
        val drawerLayout: DrawerLayout = findViewById(R.id.draw)
        val navView: NavigationView = findViewById(R.id.nav)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent1= Intent(this,Food::class.java)
        val intent2= Intent(this,Excersixes::class.java)
        val intent3= Intent(this,MainActivity::class.java)
        val intent4= Intent(this,Appointment::class.java)
        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.food->startActivity(intent1)
                R.id.excer->startActivity(intent2)
                R.id.Cal->startActivity(intent3)
                R.id.appoint->startActivity(intent4)

            }
            true

        }
        cle.setOnClickListener{
            h.setText(" ")
            w.setText(" ")

        }
        h.setOnClickListener{
            w.setText(" ")
        }
        w.setOnClickListener{
            w.setText(" ")
        }

        test.setOnClickListener {
           if(h.equals("") || w.equals("") || h.equals(" ") || w.equals(" ")){
               Toast.makeText(this, "Enter Height and Weight!!", Toast.LENGTH_SHORT).show()
           }
           else{

               val a:Float=h.text.toString().toFloat()
               val b:Float=w.text.toString().toFloat()
               val c:Float=(b/(a*a))*10000
               if(c<18.5) {
                   resuld.setText("RESULD: UNDER WEIGHT")
               }
               else if(18.5<c && c<24.9){
                   resuld.setText("RESULD: HEALTHY WEIGHT")
               }

               else if(25.0<c && c<39.9){
                   resuld.setText("RESULD: OVER WEIGHT")
               }
               else{
                   resuld.setText("RESULD: OBESITY")
               }
           }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }

}



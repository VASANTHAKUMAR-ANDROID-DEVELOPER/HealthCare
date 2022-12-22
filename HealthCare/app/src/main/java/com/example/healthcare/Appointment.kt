package com.example.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Appointment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)
        val button=findViewById<Button>(R.id.button2)
        val dbf= Firebase.database.getReference("Data")
        button.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Healthcare")
            builder.setMessage("Succesfully Registered for Appoinment")
            builder.setIcon(R.drawable.free_healthcare_icon_3610_thumb)

            val name=findViewById<EditText>(R.id.editTextTextPersonName).text
            val pone=findViewById<EditText>(R.id.editTextTextPersonName2).text
            val email=findViewById<EditText>(R.id.editTextTextPersonName3).text
            val dob=findViewById<EditText>(R.id.editTextTextPersonName4).text
            val date=findViewById<EditText>(R.id.editTextTextPersonName5).text
            val time=findViewById<EditText>(R.id.editTextTextPersonName6).text
            val type=findViewById<EditText>(R.id.editTextTextPersonName7).text
              dbf.child("$name").child("Name").setValue("$name").addOnSuccessListener {
                dbf.child("$name").child("phone").setValue("$pone")
                dbf.child("$name").child("email").setValue("$email")
                 dbf.child("$name").child("DOB").setValue("$dob")
                dbf.child("$name").child("Date").setValue("$date")
                dbf.child("$name").child("Time").setValue("$time")
                dbf.child("$name").child("Type").setValue("$type")
                builder.setPositiveButton("Ok"){dialogInterface, which ->
                    val intent= Intent(this,Homepage::class.java)
                    startActivity(intent)
                }
                //performing cancel action
                builder.setNeutralButton("Cancel"){dialogInterface , which ->
                    val intent= Intent(this,Appointment::class.java)
                    startActivity(intent)
                }
                //performing negative action

                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(false)
                alertDialog.show()
            }
            }

    }
}
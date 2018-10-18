package com.csk.chaitanyakusurkar.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    //function to calculate age
    fun calculateAge(view: View){

        val dob= editTextEnterAge.text
        //validate if data has correct length
        if (dob.length>8 || dob.length<8){
            Toast.makeText(this@MainActivity,"Enter date in MMDDYYYY format",Toast.LENGTH_LONG).show()
        }
        else{
            val currentYear:Int=Calendar.getInstance().get(Calendar.YEAR)
            val birthYear=dob.substring(4,8).toInt()
            val birthMonth=dob.substring(0,2).toInt()
            val birthdate=dob.substring(2,4).toInt()
            //validate if date, month and year are correct
           if(currentYear<birthYear ||birthMonth > 12 || birthdate >31 ){
                Toast.makeText(this@MainActivity,"Enter date is not correct. Please Re-enter your birthdate",Toast.LENGTH_LONG).show()
            }else{
               //calculate age
                val age=currentYear-birthYear
                textViewShowAge.text="Your Age is $age years"
            }

        }


    }
}

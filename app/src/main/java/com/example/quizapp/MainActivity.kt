package com.example.quizapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var score = 0
        findViewById<Button>(R.id.submit_button).setOnClickListener {
            score = 0
            val simpleDateFormat = SimpleDateFormat("yyyy-MMM-dd")
            val date: String = simpleDateFormat.format(Date())
            val answer = findViewById<RadioGroup>(R.id.radio_group).checkedRadioButtonId
            if (answer == R.id.radio_button2) score += 50

            if (findViewById<CheckBox>(R.id.checkBox1).isChecked) score -= 25
            if (findViewById<CheckBox>(R.id.checkBox2).isChecked) score += 25
            if (findViewById<CheckBox>(R.id.checkBox2).isChecked) score += 25

            val alertBuilder = AlertDialog.Builder(this@MainActivity)

            alertBuilder.setTitle("Score")
            if (score>=50)
                alertBuilder.setMessage("Congratulations! You submitted on $date\n" +
                    "and time, Your achieved $score%")
            else
                alertBuilder.setMessage("You submitted on $date\n" +
                        "and time, Your achieved $score%")
            //alertBuilder.setIcon(R.drawable.ic_done)

            alertBuilder.setPositiveButton("Close") { dialogInterface, which ->
                dialogInterface.dismiss()
            }

            val dialog = alertBuilder.create()
            dialog.show()
        }

        findViewById<Button>(R.id.reset_button).setOnClickListener {
            findViewById<RadioGroup>(R.id.radio_group).clearCheck()

            findViewById<CheckBox>(R.id.checkBox1).isChecked = false
            findViewById<CheckBox>(R.id.checkBox2).isChecked = false
            findViewById<CheckBox>(R.id.checkBox3).isChecked = false
        }
    }
}
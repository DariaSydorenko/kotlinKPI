package com.example.project1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainButton1 : Button = findViewById(R.id.mainButton1)
        val mainButton2 : Button = findViewById(R.id.mainButton2)

        mainButton1.setOnClickListener {
            val intent = Intent(this, Calculator1Activity::class.java)
            startActivity(intent)
        }

        mainButton2.setOnClickListener {
            val intent = Intent(this, Calculator2Activity::class.java)
            startActivity(intent)
        }
    }
}
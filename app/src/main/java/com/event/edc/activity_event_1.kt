package com.event.edc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_event_1 : AppCompatActivity() {

    lateinit var register:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event1)

        register = findViewById(R.id.registerForEvent)

        register.setOnClickListener {

            val intent = Intent(this , EventRegistrationForEvent1::class.java)
            startActivity(intent)

        }
    }
}
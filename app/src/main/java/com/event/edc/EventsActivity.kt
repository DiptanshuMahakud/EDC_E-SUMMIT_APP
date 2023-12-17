package com.event.edc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import com.event.edc.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.FirebaseAuth

class EventsActivity : AppCompatActivity() {


    lateinit var valo_info_button : Button
    lateinit var b_plan_info_button:Button
    lateinit var storage_wars_info_button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events)



        val toolbar : MaterialToolbar
        toolbar = findViewById(R.id.material_toolbar)

        /*********************************************
        supportActionBar?.setDisplayHomeAsUpEnabled(true)**/



        toolbar.setOnMenuItemClickListener { item->
            if(item.itemId == R.id.sign_out_user)
            {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, REgistration::class.java)
                startActivity(intent)
                finish()
            }
            return@setOnMenuItemClickListener true
        }

        valo_info_button = findViewById(R.id.valo_button)
        valo_info_button.setOnClickListener {

            val intent = Intent(this, activity_event_1::class.java)
            startActivity(intent)
        }

        b_plan_info_button= findViewById(R.id.b_plan_button)
        b_plan_info_button.setOnClickListener {

            val intent = Intent(this , activity_event_2::class.java)
            startActivity(intent)
        }


        storage_wars_info_button= findViewById(R.id.storage_wars_button)
        storage_wars_info_button.setOnClickListener {

            val intent = Intent(this, activity_event_3::class.java)
            startActivity(intent)
        }






    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            // Add other cases if needed
            else -> return super.onOptionsItemSelected(item)
        }
    }






/**
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.sign_out_user)
        {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this , REgistration::class.java)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }**/


}



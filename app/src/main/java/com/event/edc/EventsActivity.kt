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
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import com.event.edc.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.FirebaseAuth

class EventsActivity : AppCompatActivity() {


    lateinit var valo_info_button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events)



        val toolbar : MaterialToolbar
        toolbar = findViewById(R.id.material_toolbar)

       /**valo_info_button = findViewById(R.id.valo_button)
        valo_info_button.setOnClickListener {
            val intent = Intent(this, valo_description::class.java)
            startActivity(intent)
        }**/



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



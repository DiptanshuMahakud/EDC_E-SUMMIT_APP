package com.event.edc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth

class EventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events)

       /** val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "My App Title"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)**/

    }


    /**override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }**/

    /**override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.SignoutUserFromMenu)
        {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this , REgistration::class.java)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }**/


}



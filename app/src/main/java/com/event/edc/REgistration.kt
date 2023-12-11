package com.event.edc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.event.edc.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class REgistration : AppCompatActivity() {

    lateinit var loginBinding:ActivityRegistrationBinding

    val auth:FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding= ActivityRegistrationBinding.inflate(layoutInflater)
        val view=loginBinding.root
        setContentView(view)


        loginBinding.buttonSignin.setOnClickListener(){

            val userEmail = loginBinding.editTextEmailSignup.text.toString()
            val userPassword = loginBinding.editTextPasswordSignup.text.toString()
            signinWithFirebase(userEmail, userPassword)
        }

        loginBinding.buttonSignupUser.setOnClickListener()
        {
            val intent = Intent(this@REgistration, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    fun signinWithFirebase(userEmail:String, userPassword:String)
    {
        auth.signInWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, EventsActivity::class.java)
                    startActivity(intent)
                    finish()
                   
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(applicationContext, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser

        if(user != null)
        {
            val intent = Intent(this , EventsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
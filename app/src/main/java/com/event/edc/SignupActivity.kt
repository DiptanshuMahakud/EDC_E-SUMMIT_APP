package com.event.edc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.event.edc.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    lateinit var SignupBinding:ActivitySignupBinding
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SignupBinding = ActivitySignupBinding.inflate(layoutInflater)
        val view = SignupBinding.root
        setContentView(view)


        SignupBinding.buttonSignupUser.setOnClickListener()
        {
            val userEmail = SignupBinding.editTextEmailSignup.text.toString()
            val userPassword = SignupBinding.editTextPasswordSignup.text.toString()
            signupWithFirebase(userEmail, userPassword)
        }
    }

    fun signupWithFirebase(userEmail: String, userPassword:String)
    {
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener { task ->

            if(task.isSuccessful)
            {
                Toast.makeText(applicationContext, "Your Account has been Created", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(applicationContext,task.exception?.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
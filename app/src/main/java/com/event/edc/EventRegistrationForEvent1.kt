package com.event.edc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EventRegistrationForEvent1 : AppCompatActivity() {

    lateinit var TeamName:EditText
    lateinit var LeaderName:EditText
    lateinit var LeaderEmail:EditText
    lateinit var NameMember1:EditText
    lateinit var EmailMember1:EditText
    lateinit var NameMember2:EditText
    lateinit var EmailMember2:EditText
    lateinit var RegisterButton:Button
    val auth:FirebaseAuth = FirebaseAuth.getInstance()
    val user = auth.currentUser

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference:DatabaseReference = database.reference.child("Event_1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_registration_for_event1)


        TeamName= findViewById(R.id.teamName)
        LeaderEmail= findViewById(R.id.leaderEmail)
        LeaderName = findViewById(R.id.leaderName)
        NameMember1 = findViewById(R.id.nameMember1)
        EmailMember1 = findViewById(R.id.emailMember1)
        NameMember2 = findViewById(R.id.nameMember2)
        EmailMember2 = findViewById(R.id.emailMember2)
        RegisterButton = findViewById(R.id.registerForEventButton)

        RegisterButton.setOnClickListener {


            val team_name = TeamName.text.toString()
            val leader_name = LeaderName.text.toString()
            val leader_email = LeaderEmail.text.toString()
            val name_member_1 = NameMember1.text.toString()
            val email_member_1 = EmailMember1.text.toString()
            val name_member_2 = NameMember2.text.toString()
            val email_member_2 = EmailMember2.text.toString()



            val userID = user?.uid
            val userEmail = user?.email
            reference.child(team_name)
            val ref2 = reference.child(team_name)
            ref2.child("leader").child("name").setValue(leader_name)
            ref2.child("leader").child("email").setValue(leader_email)
            ref2.child("Member_1").child("name").setValue(name_member_1)
            ref2.child("Member_1").child("email").setValue(email_member_1)
            ref2.child("Member_2").child("name").setValue(name_member_2)
            ref2.child("Member_2").child("email").setValue(email_member_2)
            ref2.child("created from").child("userId").setValue(userID)
            ref2.child("created from").child("userEmail").setValue(userEmail)

            Toast.makeText(applicationContext, "Registration complete", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , EventsActivity::class.java)
            startActivity(intent)




        }



        /**registerButton.setOnClickListener {


            val userId = user?.uid


            reference.child("Team Name").setValue(team_name)
            reference.child(team_name).child("Member 1").setValue(name_Member_1)

            //if doesn't work use this
            reference.child(team_name).child(name_Member_1).child("Member 1 email").setValue(email_Member_1)
            // **********************************************************************************

            //reference.child(team_name).child(name_Member_1).child(email_Member_1).setValue(email_Member_1)
            val reference2 = reference.child(team_name)
            reference2.child("team leader uid").setValue(userId)
            Toast.makeText(applicationContext, "Registration Complete", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EventsActivity::class.java)
            startActivity(intent)

        }**/
    }
}
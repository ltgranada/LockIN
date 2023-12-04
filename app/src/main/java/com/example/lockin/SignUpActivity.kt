package com.example.lockin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
//import com.example.lockin.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var databaseReference: DatabaseReference
    //  private lateinit var fAuth : FirebaseAuth

    var editTextFName: EditText = findViewById(R.id.et_Firstname)
    var editTextLName: EditText = findViewById(R.id.et_Lastname)
    var editTextEmail: EditText = findViewById(R.id.et_Email)
    var editTextUName: EditText = findViewById(R.id.et_username)
    var editTextPass: EditText = findViewById(R.id.et_password)
    var buttonReg: Button = findViewById(R.id.btn_submit)
    var buttonback: Button = findViewById(R.id.btn_back)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        buttonReg.setOnClickListener {

            if (validateForm()) {
                val firstname = editTextFName.text.toString()
                val lastname = editTextLName.text.toString()
                val email = editTextEmail.text.toString()
                val username = editTextUName.text.toString()
                val password = editTextPass.text.toString()

                databaseReference = FirebaseDatabase.getInstance().getReference("Accounts")
                var dataKey = databaseReference.push().getKey()
                var userDetails = UserDetails(firstname, lastname, email, username, password)
                databaseReference.child("UserDetails").child(dataKey.toString())
                    .setValue(userDetails).addOnSuccessListener {
                        Toast.makeText(this, "Success - ADD", Toast.LENGTH_SHORT).show()
                    }
            }


        }


        buttonback.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }

    private fun validateForm(): Boolean {
        var valid = true

        val fname = editTextFName.text.toString()
        if (TextUtils.isEmpty(fname)) {
            editTextFName.error = "Required."
            valid = false
        } else {
            editTextFName.error = null
        }

        val lname = editTextLName.text.toString()
        if (TextUtils.isEmpty(lname)) {
            editTextLName.error = "Required."
            valid = false
        } else {
            editTextLName.error = null
        }

        val email = editTextEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            editTextEmail.error = "Required."
            valid = false
        } else {
            editTextEmail.error = null
        }

        val uname = editTextUName.text.toString()
        if (TextUtils.isEmpty(uname)) {
            editTextUName.error = "Required."
            valid = false
        } else {
            editTextUName.error = null
        }

        val pass = editTextPass.text.toString()
        if (TextUtils.isEmpty(pass)) {
            editTextPass.error = "Required."
            valid = false
        } else {
            editTextPass.error = null
        }

        return valid
    }

}
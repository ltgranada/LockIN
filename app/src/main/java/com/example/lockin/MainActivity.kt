package com.example.lockin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var userEmail: EditText
    lateinit var userPassword: EditText
    lateinit var loginButton: Button
    lateinit var signupButton: Button
    lateinit var forgotPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userEmail = findViewById(R.id.et_username)
        userPassword = findViewById(R.id.et_password)
        loginButton = findViewById(R.id.btn_sign_in)
        signupButton = findViewById(R.id.btn_signup)
        forgotPasswordButton = findViewById(R.id.btn_forget_password)

        loginButton.setOnClickListener(View.OnClickListener {
            if (validateForm()) {
                loginUser()
                startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
            }
        })

        signupButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        })

        forgotPasswordButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        })
    }

    private fun validateForm(): Boolean {
        var valid = true

        val email = userEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            userEmail.error = "Required."
            valid = false
        } else {
            userEmail.error = null
        }

        val password = userPassword.text.toString()
        if (TextUtils.isEmpty(password)) {
            userPassword.error = "Required."
            valid = false
        } else {
            userPassword.error = null
        }

        return valid
    }

    private fun loginUser() {
        // implement your own logic to validate user credentials
        // typically done via network API
    }
}
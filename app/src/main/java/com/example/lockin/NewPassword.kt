package com.example.lockin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewPassword : AppCompatActivity() {
    var enterWeb: EditText = findViewById(R.id.entWeb)
    var enterUser: EditText = findViewById(R.id.entUser)
    var enterPass: EditText = findViewById(R.id.entPass)
    var saveButton: Button = findViewById(R.id.backbtn)
    var backButton: Button = findViewById(R.id.savebtn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newpassword)





    }
}
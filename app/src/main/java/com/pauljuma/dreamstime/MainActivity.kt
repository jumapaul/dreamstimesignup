package com.pauljuma.dreamstime

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.login_now).setOnClickListener { loginNow(it) }

    }


    private fun loginNow(view: View) {
        val name = findViewById<EditText>(R.id.myName)
        val number = findViewById<EditText>(R.id.myNumber)
        val email = findViewById<EditText>(R.id.myEmail)
        val setpassword = findViewById<EditText>(R.id.myPassword)
        val confirmedPassword = findViewById<EditText>(R.id.confirmPassword)
        val termsCheckbox = findViewById<CheckBox>(R.id.terms)
        val subscription = findViewById<CheckBox>(R.id.subscribe)

        if (name.text.isNotEmpty() && number.text.isNotEmpty() && email.text.isNotEmpty()
            && setpassword.text.isNotEmpty() && confirmedPassword.text.isNotEmpty() &&
            termsCheckbox.isChecked && subscription.isChecked
        ) {

            if (number.text.toString().length < 10) {
                Toast.makeText(this, "You have entered an invalid number", Toast.LENGTH_SHORT)
                    .show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString())
                    .matches()
            ) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            } else if (setpassword.text.length < 6) {
                Toast.makeText(this, "Password should be above six characters", Toast.LENGTH_SHORT)
                    .show()
            } else if (setpassword.text.toString() != confirmedPassword.text.toString()) {
                Toast.makeText(this, "Ensure the passwords are the same", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You have logged in", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Enter your credentials", Toast.LENGTH_SHORT).show()
        }
    }


}



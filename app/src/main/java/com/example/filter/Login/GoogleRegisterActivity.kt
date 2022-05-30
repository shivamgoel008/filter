package com.example.filter.Login

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.filter.R
import com.example.filter.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_google_register.*

class GoogleRegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_register)
        auth = FirebaseAuth.getInstance()

        progressBar2.visibility = View.GONE

        register.setOnClickListener {
            firebaseEmailRegister.error = null
            firebasePasswordRegister.error = null

            val email = firebaseEmailRegister.editText?.text.toString()
            val pass = firebasePasswordRegister.editText?.text.toString()

            if (validateInput(email, pass)) {
                progressBar2.visibility = View.VISIBLE

                // authenticating user
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    progressBar2.visibility = View.INVISIBLE

                    if (task.isSuccessful) {
                        val intent = Intent(this@GoogleRegisterActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        val toast = Toast.makeText(
                            this@GoogleRegisterActivity,
                            "Authentication failed: ${task.exception?.message}",
                            Toast.LENGTH_LONG
                        )
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                        toast.show()
                    }
                }

            }
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        UpdateUI(currentUser)
    }

    private fun UpdateUI(currentUser: FirebaseUser?) {

        if (currentUser != null) {
            val intent = Intent(this@GoogleRegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateInput(email: String, pass: String): Boolean {
        var valid = true
        if (email.isBlank()) {
            firebaseEmailRegister.error = "Please enter an email address"
            valid = false
        } else if (pass.length < 8) {
            firebasePasswordRegister.error = "Password show 8 character or more"
            valid = false
        }

        return valid
    }

}
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
import kotlinx.android.synthetic.main.activity_google_login.*

class GoogleLoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_login)

        auth = FirebaseAuth.getInstance()
        progressBar.visibility = View.GONE

//        if (this.auth.currentUser != null) {
//            val intent = Intent(this@GoogleLoginActivity, MainActivity::class.java)
//            startActivity(intent)
//        }

        not_registered.setOnClickListener {
            val intent = Intent(this@GoogleLoginActivity, GoogleRegisterActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            firebaseEmailLogin.error = null
            firebasePasswordLogin.error = null

            val email = firebaseEmailLogin.editText?.text.toString()
            val pass = firebasePasswordLogin.editText?.text.toString()

            if (validateInput(email, pass)) {
                progressBar.visibility = View.VISIBLE

                // authenticating user
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    progressBar.visibility = View.INVISIBLE

                    if (task.isSuccessful) {
                        val intent = Intent(this@GoogleLoginActivity, MainActivity::class.java)
                        startActivity(intent)

                    } else {
                        val toast = Toast.makeText(
                            this@GoogleLoginActivity,
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
            val intent = Intent(this@GoogleLoginActivity, MainActivity::class.java)
            startActivity(intent)

        }
    }

    private fun validateInput(email: String, pass: String): Boolean {
        var valid = true
        if (email.isBlank()) {
            firebaseEmailLogin.error = "Please enter an email address"
            valid = false
        } else if (pass.length < 8) {
            firebasePasswordLogin.error = "Password show 8 character or more"
            valid = false
        }

        return valid
    }
}
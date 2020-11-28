package com.example.mealdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        setupViews()
    }

    private fun setupViews(){
        signupButton.setOnClickListener() {
            val username = editTextUsername.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPsswd.text.toString()
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { result ->
                    if (!result.isSuccessful) {
                        Toast.makeText(this, result.exception.toString(), Toast.LENGTH_LONG).show()

                        return@addOnCompleteListener
                    }

                    Toast.makeText(this, result.result?.user?.email, Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
        }

    }
}

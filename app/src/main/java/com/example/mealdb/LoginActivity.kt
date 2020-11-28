package com.example.mealdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupViews()
    }

    private fun setupViews(){
        loginButton.setOnClickListener {
            val email = editTextEmailSignin.text.toString()
            val password = editTextPsswdSignin.text.toString()

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { result ->
                    if (!result.isSuccessful) {
                        Toast.makeText(this,
                            result.exception.toString(), Toast.LENGTH_LONG).show()

                        return@addOnCompleteListener
                    }
                    Toast.makeText(this, result.result?.user?.email,
                        Toast.LENGTH_LONG).show()

                    startActivity(Intent(this, MenuActivity::class.java))
                    finish()
                }
        }

    }
}

package com.example.mealdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }

    private fun setupViews(){
        val currentUser = FirebaseAuth.getInstance().currentUser
        if(currentUser != null){
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }

        button.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        signup_textView.setOnClickListener{
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }
    }

}


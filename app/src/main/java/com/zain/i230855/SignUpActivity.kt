package com.zain.i230855

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signup_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<ImageView>(R.id.btn_back)
        val btnCreateAccount = findViewById<TextView>(R.id.btn_do_create_account)
        val tvAlreadyHaveAccount = findViewById<TextView>(R.id.tv_already_have_account)

        btnBack.setOnClickListener {
            finish()
        }

        tvAlreadyHaveAccount.setOnClickListener {
            finish()
        }

        btnCreateAccount.setOnClickListener {
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}
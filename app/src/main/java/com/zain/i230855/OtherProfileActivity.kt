package com.zain.i230855

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OtherProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_other_profile)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.other_profile_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<ImageView>(R.id.btn_other_back)
        val btnAddFriend = findViewById<TextView>(R.id.btn_add_friend)
        val btnMessage = findViewById<TextView>(R.id.btn_message)

        btnBack.setOnClickListener {
            finish()
        }

        btnAddFriend.setOnClickListener {
            Toast.makeText(this, "Friend request sent to Omar Farooq!", Toast.LENGTH_SHORT).show()
        }

        btnMessage.setOnClickListener {
            Toast.makeText(this, "Opening chat with Omar Farooq...", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.zain.i230855

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edit_profile_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCancel = findViewById<TextView>(R.id.btn_edit_cancel)
        val btnSave = findViewById<TextView>(R.id.btn_edit_save)

        btnCancel.setOnClickListener {
            finish()
        }

        btnSave.setOnClickListener {
            Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
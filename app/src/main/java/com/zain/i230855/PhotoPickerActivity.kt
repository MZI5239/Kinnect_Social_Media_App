package com.zain.i230855

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PhotoPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photo_picker)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.photo_picker_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCancel = findViewById<TextView>(R.id.btn_picker_cancel)
        val btnNext = findViewById<TextView>(R.id.btn_picker_next)
        val btnCamera = findViewById<View>(R.id.btn_open_camera_from_picker)

        btnCancel.setOnClickListener {
            finish()
        }

        btnNext.setOnClickListener {
            Toast.makeText(this, "2 photos selected!", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnCamera.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }
    }
}
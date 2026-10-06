package com.zain.i230855

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_camera)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.camera_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnClose = findViewById<ImageView>(R.id.btn_camera_close)
        val btnShutter = findViewById<View>(R.id.btn_shutter)

        btnClose.setOnClickListener {
            finish()
        }

        btnShutter.setOnClickListener {
            Toast.makeText(this, "Photo captured!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, StoryEditorActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
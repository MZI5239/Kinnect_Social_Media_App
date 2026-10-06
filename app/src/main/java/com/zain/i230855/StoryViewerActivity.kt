package com.zain.i230855

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StoryViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story_viewer)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.story_viewer_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnClose = findViewById<ImageView>(R.id.btn_viewer_close)
        val btnHeart = findViewById<TextView>(R.id.btn_quick_heart)
        val btnLike = findViewById<TextView>(R.id.btn_quick_like)

        btnClose.setOnClickListener {
            finish()
        }

        btnHeart.setOnClickListener {
            Toast.makeText(this, "Loved story!", Toast.LENGTH_SHORT).show()
        }

        btnLike.setOnClickListener {
            Toast.makeText(this, "Liked story!", Toast.LENGTH_SHORT).show()
        }
    }
}
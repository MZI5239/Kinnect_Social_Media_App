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

class StoryEditorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story_editor)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.story_editor_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnClose = findViewById<ImageView>(R.id.btn_story_close)
        val btnShareYourStory = findViewById<View>(R.id.btn_share_your_story)
        val btnShareCloseFriends = findViewById<View>(R.id.btn_share_close_friends)

        btnClose.setOnClickListener {
            finish()
        }

        btnShareYourStory.setOnClickListener {
            Toast.makeText(this, "Shared to your story!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        btnShareCloseFriends.setOnClickListener {
            Toast.makeText(this, "Shared to Close Friends!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
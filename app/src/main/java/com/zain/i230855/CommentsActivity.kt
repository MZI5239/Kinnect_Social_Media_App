package com.zain.i230855

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_comments)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.comments_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<ImageView>(R.id.btn_comments_back)
        val etInput = findViewById<EditText>(R.id.et_comment_input)
        val btnSend = findViewById<TextView>(R.id.btn_send_comment)

        btnBack.setOnClickListener {
            finish()
        }

        btnSend.setOnClickListener {
            val text = etInput.text.toString().trim()
            if (text.isNotEmpty()) {
                Toast.makeText(this, "Comment posted!", Toast.LENGTH_SHORT).show()
                etInput.text.clear()
            }
        }
    }
}
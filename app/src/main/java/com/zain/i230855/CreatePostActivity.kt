package com.zain.i230855

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreatePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_post)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.create_post_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<ImageView>(R.id.btn_create_post_back)
        val btnPost = findViewById<TextView>(R.id.btn_do_post)
        val postContainer = findViewById<View>(R.id.post_input_container)
        val etPostText = findViewById<EditText>(R.id.et_post_text)

        btnBack.setOnClickListener {
            finish()
        }

        btnPost.setOnClickListener {
            Toast.makeText(this, "Post published!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Color selector palette logic
        fun applyBgColor(colorHex: String, isDarkBg: Boolean) {
            postContainer.setBackgroundColor(colorHex.toColorInt())
            if (isDarkBg) {
                etPostText.setTextColor(Color.WHITE)
                etPostText.setHintTextColor("#B0FFFFFF".toColorInt())
            } else {
                etPostText.setTextColor("#1C1B1F".toColorInt())
                etPostText.setHintTextColor("#8A8D91".toColorInt())
            }
        }

        findViewById<View>(R.id.color_white)?.setOnClickListener { applyBgColor("#FFFFFF", isDarkBg = false) }
        findViewById<View>(R.id.color_teal)?.setOnClickListener { applyBgColor("#0B5F63", isDarkBg = true) }
        findViewById<View>(R.id.color_red)?.setOnClickListener { applyBgColor("#BA4929", isDarkBg = true) }
        findViewById<View>(R.id.color_purple)?.setOnClickListener { applyBgColor("#4B4F8E", isDarkBg = true) }
        findViewById<View>(R.id.color_green)?.setOnClickListener { applyBgColor("#2F6B4F", isDarkBg = true) }
        findViewById<View>(R.id.color_gold)?.setOnClickListener { applyBgColor("#C98611", isDarkBg = true) }
        findViewById<View>(R.id.color_magenta)?.setOnClickListener { applyBgColor("#7A4E7F", isDarkBg = true) }
        findViewById<View>(R.id.color_black)?.setOnClickListener { applyBgColor("#1C1B19", isDarkBg = true) }

        // Specific navigation actions for attachment options
        findViewById<View>(R.id.opt_photo_video)?.setOnClickListener {
            val intent = Intent(this, PhotoPickerActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.opt_camera)?.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        val otherOptions = mapOf(
            R.id.opt_tag_people to "Tag people",
            R.id.opt_feeling to "Feeling/activity",
            R.id.opt_checkin to "Check in",
            R.id.opt_live_video to "Live video",
            R.id.opt_create_event to "Create event",
        )

        for ((id, name) in otherOptions) {
            findViewById<View>(id)?.setOnClickListener {
                Toast.makeText(this, "$name selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
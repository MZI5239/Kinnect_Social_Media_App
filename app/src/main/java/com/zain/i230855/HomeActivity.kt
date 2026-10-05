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

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSearch = findViewById<View>(R.id.btn_home_search)
        val btnChat = findViewById<View>(R.id.btn_home_chat)
        val tvWhatsOnMind = findViewById<TextView>(R.id.tv_whats_on_your_mind)
        val btnComment = findViewById<View>(R.id.btn_comment)
        val btnLike = findViewById<View>(R.id.btn_like)
        val itemCreateStory = findViewById<View>(R.id.item_create_story)

        // Top Navigation Tabs
        val tabFriends = findViewById<View>(R.id.tab_friends)
        val tabMarketplace = findViewById<View>(R.id.tab_marketplace)
        val tabNotifications = findViewById<View>(R.id.tab_notifications)
        val tabMenu = findViewById<View>(R.id.tab_menu)

        btnSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        btnChat.setOnClickListener {
            val intent = Intent(this, ChatsActivity::class.java)
            startActivity(intent)
        }

        tvWhatsOnMind.setOnClickListener {
            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent)
        }

        // "Create story" opens Camera
        itemCreateStory.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

        // Navigation Tabs
        tabFriends.setOnClickListener {
            val intent = Intent(this, FriendsActivity::class.java)
            startActivity(intent)
        }

        tabMarketplace.setOnClickListener {
            val intent = Intent(this, MarketplaceActivity::class.java)
            startActivity(intent)
        }

        tabNotifications.setOnClickListener {
            val intent = Intent(this, NotificationsActivity::class.java)
            startActivity(intent)
        }

        tabMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        btnComment.setOnClickListener {
            val intent = Intent(this, CommentsActivity::class.java)
            startActivity(intent)
        }

        btnLike.setOnClickListener {
            Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show()
        }

        btnLike.setOnLongClickListener {
            val intent = Intent(this, ReactionPickerActivity::class.java)
            startActivity(intent)
            true
        }
    }
}
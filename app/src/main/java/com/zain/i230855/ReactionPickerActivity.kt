package com.zain.i230855

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReactionPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reaction_picker)

        val root = findViewById<android.view.View>(R.id.reaction_root)
        val rLike = findViewById<TextView>(R.id.reaction_like)
        val rLove = findViewById<TextView>(R.id.reaction_love)
        val rHaha = findViewById<TextView>(R.id.reaction_haha)
        val rWow = findViewById<TextView>(R.id.reaction_wow)
        val rSad = findViewById<TextView>(R.id.reaction_sad)
        val rAngry = findViewById<TextView>(R.id.reaction_angry)

        root.setOnClickListener {
            finish()
        }

        fun onReact(reactionName: String) {
            Toast.makeText(this, "Reacted with $reactionName", Toast.LENGTH_SHORT).show()
            finish()
        }

        rLike.setOnClickListener { onReact("Like") }
        rLove.setOnClickListener { onReact("Love") }
        rHaha.setOnClickListener { onReact("Haha") }
        rWow.setOnClickListener { onReact("Wow") }
        rSad.setOnClickListener { onReact("Sad") }
        rAngry.setOnClickListener { onReact("Angry") }
    }
}
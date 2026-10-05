package com.zain.i230855

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val ivPasswordToggle = findViewById<ImageView>(R.id.iv_password_toggle)
        val btnLogin = findViewById<TextView>(R.id.btn_login)
        val btnCreateAccount = findViewById<TextView>(R.id.btn_create_account)
        val cardRecentUser = findViewById<android.view.View>(R.id.card_recent_user)
        val tvForgotPassword = findViewById<TextView>(R.id.tv_forgot_password)

        // Password visibility toggle
        ivPasswordToggle.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etPassword.setSelection(etPassword.text.length)
        }

        // Tap recent user card to auto-fill
        cardRecentUser.setOnClickListener {
            etUsername.setText(R.string.user_email)
            etPassword.setText(R.string.default_password)
            Toast.makeText(this, R.string.tap_profile_to_login, Toast.LENGTH_SHORT).show()
        }

        // Log in button click listener
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()

            if (username.isEmpty()) {
                etUsername.error = getString(R.string.mobile_or_email_label)
                return@setOnClickListener
            }

            // Navigate to HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Create new account button click listener
        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        tvForgotPassword.setOnClickListener {
            Toast.makeText(this, R.string.forgot_password, Toast.LENGTH_SHORT).show()
        }
    }
}
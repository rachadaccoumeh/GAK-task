package com.example.gak_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gak_task.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        //login in using shared preferences
        //if user is logged in then go to main activity
        val sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        binding.loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            // the condition must be changed to the real condition
            if (username == "admin" && password == "admin" || true) {
                editor.putBoolean("IS_LOGGED_IN", true)
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}
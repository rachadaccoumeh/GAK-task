package com.example.gak_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.gak_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logoutButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("IS_LOGGED_IN", false)
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}
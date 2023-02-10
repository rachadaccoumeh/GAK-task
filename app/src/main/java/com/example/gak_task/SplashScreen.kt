package com.example.gak_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        // This is the loading time of the splash screen
        val SPLASH_TIME_OUT: Long = 1000 // 1 sec
        Handler().postDelayed({
            // This method will be executed once the timer is over
            //check if user is signed in using shared preferences
            val sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
            val isUserLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false)
            val intent: Intent = if (isUserLoggedIn) {
                //user is logged in
                Intent(this, MainActivity::class.java)
            } else {
                //user is not logged in
                Intent(this, LoginActivity::class.java)
            }
            startActivity(intent)



            finish()
        }, SPLASH_TIME_OUT)


    }
}
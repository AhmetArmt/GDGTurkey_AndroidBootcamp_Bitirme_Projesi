package com.example.harcamatakipapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.harcamatakipapp.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splasBaslik.alpha = 0f
        splasBaslik.animate().setDuration(2300).alpha(1f).withEndAction {
            val gecisIntent = Intent(this, MainActivity::class.java)
            startActivity(gecisIntent)
            finish()
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }

    }

    }

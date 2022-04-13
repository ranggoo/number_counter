package com.example.numberCounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.numberCounter.util.ActivityUtil.setStatusBarTransparent

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setStatusBarTransparent()
    }
}
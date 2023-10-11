package com.example.first_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.first_app.databinding.ActivityScrollableBinding

class ScrollableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollableBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvGreeting.text = "Ini adalah hasil binding"
    }
}
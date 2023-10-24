package com.example.first_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.first_app.databinding.ActivitySpotDetailBinding

class SpotDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpotDetailBinding
    private lateinit var spot: Spots
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpotDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spot = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Spots>("extra_spot", Spots::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Spots>("extra_spot")
        }
        binding.tvTitle.text = spot?.cardBody ?: "belum diatur"
        binding.tvAddress.text = spot?.cardTitle ?: "belum diatur"
    }
}
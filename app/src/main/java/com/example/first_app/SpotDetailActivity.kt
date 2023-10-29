package com.example.first_app

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.first_app.databinding.ActivitySpotDetailBinding

class SpotDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySpotDetailBinding
    private lateinit var spot: Spots

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult( )
    ) { result ->
        if (result.resultCode == PaymentActivity.RESULT_CODE && result.data != null) {
            val selectedValue = result.data?.getIntExtra(PaymentActivity.EXTRA_SELECTED_VALUE, 0)
            binding.tvPembayaran.text = "Metode Pembayaran: pilihan $selectedValue"
        }
    }
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

        binding.btnPembayaran.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@SpotDetailActivity, PaymentActivity::class.java)
        resultLauncher.launch(intent)
    }
}
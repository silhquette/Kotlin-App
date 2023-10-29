package com.example.first_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.first_app.databinding.ActivityGetDataBinding

class GetDataActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGetDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGetDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener(this)
        Log.d("asd", intent.getStringExtra("extra_keyword").toString())
        binding.tvSubTitle.text = "Hasil pencarian untuk " + intent.getStringExtra("extra_keyword")
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_back -> {
                onBackPressed()
            }
        }
    }
}
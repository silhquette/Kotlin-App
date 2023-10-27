package com.example.first_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.first_app.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_select -> {
                var value = 0
                when (binding.radioGroup.checkedRadioButtonId) {
                    R.id.rb_1 -> value = 1
                    R.id.rb_2 -> value = 2
                    R.id.rb_3 -> value = 3
                    else -> value = 0
                }

                val resultIntent = Intent().putExtra("extra_selected_value", value)
                setResult(110, resultIntent)
                finish()
            }
        }
    }
}
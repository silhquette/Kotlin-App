package com.example.first_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    // Register Component
    private lateinit var radioGroup: RadioGroup
    private lateinit var process: Button
    private lateinit var result: TextView
    private lateinit var radio: RadioButton
    private lateinit var hasil_temp: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Component Init
        radioGroup = findViewById(R.id.radio_group)
        process = findViewById(R.id.button_process)
    }
}


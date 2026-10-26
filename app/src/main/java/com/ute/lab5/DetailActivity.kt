package com.ute.lab5

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.lab5.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ten = intent.getStringExtra("TEN")
        binding.tvResult.text = "Thông tin tân sinh viên:\nHọ tên: $ten"

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
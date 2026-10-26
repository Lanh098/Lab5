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

        val ThongTin = intent.getSerializableExtra("SV_INFO") as? SinhVien
        if (ThongTin != null) {
            binding.tvResult1.text = "Họ tên : ${ThongTin.ten}"
            binding.tvResult2.text = "Email : ${ThongTin.email}"
            binding.tvResult3.text = "Mật khẩu : ${ThongTin.matKhau}"
            binding.tvResult4.text = "Số điện thoại : ${ThongTin.sdt}"
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
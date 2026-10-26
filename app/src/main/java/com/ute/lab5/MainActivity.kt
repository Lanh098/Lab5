package com.ute.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.ute.lab5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Nhập chữ
        binding.etName.doAfterTextChanged {
            Toast.makeText(this, "Đang gõ: $it", Toast.LENGTH_SHORT).show()
        }
        //Giới tính
        binding.rgGender.setOnCheckedChangeListener { _, checkedId ->
            val gioiTinh = if (checkedId == R.id.rbMale) "Nam" else "Nữ"
            Toast.makeText(this, "Chọn: $gioiTinh", Toast.LENGTH_SHORT).show()
        }
        //Checkbox
        binding.cbFacebook.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Facebook: $isChecked", Toast.LENGTH_SHORT).show()
        }
        //Chuyển màn hình
        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("TEN", binding.etName.text.toString())
            startActivity(intent)
        }
    }
}
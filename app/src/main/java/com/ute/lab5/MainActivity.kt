package com.ute.lab5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.lab5.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nút Đăng ký
        binding.btnSubmit.setOnClickListener { view ->
            val ten = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val matKhau = binding.etPW.text.toString()
            val sdt = binding.etPhone.text.toString()

            // Kiểm tra điều kiện bằng FormValidator
            if (!FormValidator.isValidName(ten)) {
                Snackbar.make(view, "Họ tên phải từ 3 ký tự trở lên!", Snackbar.LENGTH_LONG).show()
            } else if (!FormValidator.isValidEmail(email)) {
                Snackbar.make(view, "Email không đúng định dạng!", Snackbar.LENGTH_LONG).show()
            } else if (!FormValidator.isValidPhone(sdt)) {
                Snackbar.make(view, "Số điện thoại không hợp lệ (10 số, đầu 03/05/07/08/09)!", Snackbar.LENGTH_LONG).show()
            } else if (!FormValidator.isValidPassword(matKhau)) {
                Snackbar.make(view, "Mật khẩu phải từ 6 ký tự trở lên!", Snackbar.LENGTH_LONG).show()
            } else if (!binding.cbDieuKhoan.isChecked) {
                Snackbar.make(view, "Bạn phải đồng ý với điều khoản sử dụng!", Snackbar.LENGTH_LONG).show()
            } else if (binding.rgGender.checkedRadioButtonId == -1) {
                Snackbar.make(view, "Bạn phải chọn giới tính!", Snackbar.LENGTH_LONG).show()
            }
            else {
                // Hợp lệ -> Chuyển sang màn hình trang chủ
                val SinhVien = SinhVien(ten, email, matKhau, sdt)
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("SV_INFO", SinhVien)
                startActivity(intent)
            }
        }

        // Nút Hủy
        binding.btnCancel.setOnClickListener {
            binding.etName.text.clear()
            binding.etEmail.text.clear()
            binding.etPW.text.clear()
            binding.etPhone.text.clear()
            binding.rgGender.clearCheck()
            binding.cbFacebook.isChecked = false
            binding.cbTiktok.isChecked = false
        }
    }
}
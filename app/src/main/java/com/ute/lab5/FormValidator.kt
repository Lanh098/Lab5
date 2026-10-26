package com.ute.lab5

object FormValidator {
    private val EMAIL_REGEX = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private val PHONE_REGEX = Regex("^(03|05|07|08|09)\\d{8}$")
    // Điều kiện: Họ tên từ 3 ký tự trở lên
    fun isValidName(name: String) = name.trim().length >= 3
    // Điều kiện: Email đúng định dạng
    fun isValidEmail(email: String) = email.isNotBlank() && EMAIL_REGEX.matches(email.trim())
    // Điều kiện: Mật khẩu tối thiểu 6 ký tự
    fun isValidPassword(pass: String) = pass.length >= 6
    // Điều kiện: Số điện thoại đúng 10 số, bắt đầu bằng 03, 05, 07, 08, 09
    fun isValidPhone(phone: String) = PHONE_REGEX.matches(phone.trim())
}
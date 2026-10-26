package com.ute.lab5
import java.io.Serializable
data class SinhVien(
    val ten: String,
    val email: String,
    val matKhau: String,
    val sdt: String
) : Serializable
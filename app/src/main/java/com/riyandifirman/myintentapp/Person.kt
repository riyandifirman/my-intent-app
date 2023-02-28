package com.riyandifirman.myintentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Parcelable adalah sebuah interface yang digunakan untuk mengirimkan data antar activity
// Parcelize adalah sebuah annotation yang digunakan untuk membuat class Parcelable
@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable

package com.redpond.domain

data class Country(
    val code: String,
    val name: String,
    val capital: String? = null,
    val currency: String? = null,
)

package com.maxwillian.myFirstSpringKotlinCrud

data class Book(
        val id: String? = null,
        val name: String,
        val author: String? = "",
        val code: String,
        val price: Long? = 0
)
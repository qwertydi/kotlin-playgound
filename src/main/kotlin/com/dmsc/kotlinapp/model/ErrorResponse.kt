package com.dmsc.kotlinapp.model

data class ErrorResponse(
    val status: Int,
    val error: String,
    val message: String
)

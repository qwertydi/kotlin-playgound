package com.dmsc.kotlinapp.exception

import org.springframework.http.HttpStatus

class ResourceNotFoundException(message: String, val status: HttpStatus) : RuntimeException(message)
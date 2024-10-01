package com.dmsc.kotlinapp.service

import com.dmsc.kotlinapp.model.AppItem
import com.dmsc.kotlinapp.model.AppResponse

interface AppService {
    fun listAppUser(): AppResponse

    fun createUser(name: String, email: String): AppItem
}
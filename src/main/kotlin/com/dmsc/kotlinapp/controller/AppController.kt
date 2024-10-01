package com.dmsc.kotlinapp.controller;

import com.dmsc.kotlinapp.model.AppItem
import com.dmsc.kotlinapp.model.AppResponse
import com.dmsc.kotlinapp.service.AppService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController(private var appService: AppService) {

    @GetMapping
    suspend fun getUsers(): AppResponse {
        return appService.listAppUser()
    }

    @PostMapping
    suspend fun createUser(@RequestParam name: String, @RequestParam email: String): AppItem {
        // Call the service to create and save a new user
        return appService.createUser(name, email)
    }
}

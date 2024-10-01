package com.dmsc.kotlinapp.service

import com.dmsc.kotlinapp.entity.AppEntity
import com.dmsc.kotlinapp.model.AppItem
import com.dmsc.kotlinapp.model.AppResponse
import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Flux

interface AppService {
    suspend fun listAppUser(): AppResponse

    suspend fun createUser(name: String, email: String): AppItem
}
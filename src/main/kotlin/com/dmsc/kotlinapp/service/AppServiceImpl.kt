package com.dmsc.kotlinapp.service;

import com.dmsc.kotlinapp.entity.AppEntity
import com.dmsc.kotlinapp.model.AppItem
import com.dmsc.kotlinapp.model.AppResponse
import com.dmsc.kotlinapp.repository.AppRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AppServiceImpl(private val appRepository: AppRepository) : AppService {
    private val log = LoggerFactory.getLogger(this.javaClass)

    override suspend fun listAppUser(): AppResponse {
        log.info("List Users")

        val list = appRepository.findAll()
            .asFlow()
            .map { entity -> AppItem(
                name = entity.name,
                email = entity.email
            ) }
            .toList()

        return AppResponse(list)
    }

    override suspend fun createUser(name: String, email: String): AppItem {
        log.info("Create User")
        val createdUser = AppEntity(name = name, email = email)

        return appRepository.save(createdUser).map { x -> AppItem.fromEntity(x) }.awaitSingle()
    }
}

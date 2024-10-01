package com.dmsc.kotlinapp.service;

import com.dmsc.kotlinapp.entity.AppEntity
import com.dmsc.kotlinapp.exception.ResourceNotFoundException
import com.dmsc.kotlinapp.model.AppItem
import com.dmsc.kotlinapp.model.AppResponse
import com.dmsc.kotlinapp.repository.AppRepository
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils

@Service
class AppServiceImpl(private val appRepository: AppRepository) : AppService {
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun listAppUser(): AppResponse {
        log.atInfo().log("List All Users")
        val findAll = appRepository.findAll()
        if (CollectionUtils.isEmpty(findAll)) {
            throw ResourceNotFoundException("Data not found", HttpStatus.NOT_FOUND)
        }

        val appResponse = AppResponse()
        findAll.forEach { appEntity -> appResponse.addItem(AppItem(appEntity.name, appEntity.email)) }
        return appResponse
    }

    override fun createUser(name: String, email: String): AppItem {
        log.atInfo().log("Create User")

        val createdUser = AppEntity(name = name, email = email)

        return AppItem.fromEntity(appRepository.save(createdUser))
    }
}

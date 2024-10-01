package com.dmsc.kotlinapp.repository

import com.dmsc.kotlinapp.entity.AppEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AppRepository : ReactiveCrudRepository<AppEntity, Long>
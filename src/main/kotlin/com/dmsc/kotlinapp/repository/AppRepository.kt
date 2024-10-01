package com.dmsc.kotlinapp.repository

import com.dmsc.kotlinapp.entity.AppEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppRepository : JpaRepository<AppEntity, Long>
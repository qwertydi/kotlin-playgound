package com.dmsc.kotlinapp.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table
data class AppEntity(
    @Id
    val id: Long? = null, // id is nullable for new entities (not persisted yet)
    var name: String,
    val email: String
)
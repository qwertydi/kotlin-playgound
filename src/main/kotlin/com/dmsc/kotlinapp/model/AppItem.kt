package com.dmsc.kotlinapp.model;

import com.dmsc.kotlinapp.entity.AppEntity

data class AppItem(val name: String, val email: String) {
    companion object {
        fun fromEntity(save: AppEntity): AppItem {
            return AppItem(name = save.name, email = save.email)
        }
    }
}

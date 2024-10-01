package com.dmsc.kotlinapp.model

class AppResponse {
    private val items: MutableCollection<AppItem> = mutableListOf()

    fun addItem(item: AppItem) {
        items.add(item)
    }
}
package com.conboi.gray.interfaces

interface CacheLinkRepository {
    fun saveLink(value: String)
    fun getLink(): String
}
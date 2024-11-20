package com.fabianospdev.petscare.domain.entities

interface RemoteUserEntity {
    val id: Int
    val name: String
    val email: String
    val password: String
    val createdAt: String
}
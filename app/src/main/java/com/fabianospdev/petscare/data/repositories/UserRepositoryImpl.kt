package com.fabianospdev.petscare.data.repositories

import com.fabianospdev.petscare.data.models.User
import com.fabianospdev.petscare.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi, // Supondo que seja uma API externa
    private val userDao: UserDao // Supondo que seja um banco de dados local
) : UserRepository {

    override suspend fun getUser(username: String, password: String): User {
        // Aqui você pode adicionar a lógica para buscar o usuário na API ou banco de dados
        val response = userApi.getUser(username, password)

        // Se a API retornar com sucesso, convertemos para o modelo `User`
        if (response.isSuccessful) {
            return response.body()?.let { User(it.id, it.username, it.email) }
                ?: throw Exception("User not found")
        } else {
            throw Exception("Failed to fetch user")
        }
    }
}

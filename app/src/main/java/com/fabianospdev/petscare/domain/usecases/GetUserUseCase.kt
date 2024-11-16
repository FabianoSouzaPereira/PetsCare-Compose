package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.data.models.User
import com.fabianospdev.petscare.domain.repositories.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun execute(username: String, password: String): User {
        // Aqui você pode adicionar regras de negócio antes de chamar o repositório
        if (username.isEmpty() || password.isEmpty()) {
            throw IllegalArgumentException("Username and password cannot be empty")
        }

        // Chama o repositório para pegar o usuário
        return userRepository.getUser(username, password)
    }
}

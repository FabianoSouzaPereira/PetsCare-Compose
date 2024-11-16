package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.domain.repositories.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
}
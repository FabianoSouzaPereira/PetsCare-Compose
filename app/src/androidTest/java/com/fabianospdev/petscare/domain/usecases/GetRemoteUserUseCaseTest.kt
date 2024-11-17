package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.domain.repositories.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class GetRemoteUserUseCaseTest {

    private lateinit var getUserUseCase: GetUserUseCase
    private lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        userRepository = mock(UserRepository::class.java)
        getUserUseCase = GetUserUseCase(userRepository)
    }

    @Test
    fun should_return_user_when_valid_username_and_password_are_provided() = runBlocking {

    }

    @Test
    fun should_throw_exception_when_username_or_password_is_empty() = runBlocking {

    }
}

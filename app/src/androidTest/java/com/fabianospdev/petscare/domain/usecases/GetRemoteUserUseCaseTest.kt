package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.domain.repositories.UserRemoteRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class GetRemoteUserUseCaseTest {

    private lateinit var getUserUseCase: UserRemoteUsecase
    private lateinit var userRepository: UserRemoteRepository

    @Before
    fun setup() {
        userRepository = mock(UserRemoteRepository::class.java)
        getUserUseCase = UserRemoteUsecase(userRepository)
    }

    @Test
    fun should_return_user_when_valid_username_and_password_are_provided() = runBlocking {

    }

    @Test
    fun should_throw_exception_when_username_or_password_is_empty() = runBlocking {

    }
}

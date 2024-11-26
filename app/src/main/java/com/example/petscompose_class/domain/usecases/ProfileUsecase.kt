package com.example.petscompose_class.domain.usecases

import com.example.petscompose_class.domain.repositories.ProfileRemoteRepository
import javax.inject.Inject

class ProfileUsecase @Inject constructor(
    private val profileRepository: ProfileRemoteRepository
) {
}
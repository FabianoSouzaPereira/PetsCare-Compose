package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.domain.repositories.ProfileRemoteRepository
import javax.inject.Inject

class ProfileUsecase @Inject constructor(
    private val profileRepository: ProfileRemoteRepository
) {
}
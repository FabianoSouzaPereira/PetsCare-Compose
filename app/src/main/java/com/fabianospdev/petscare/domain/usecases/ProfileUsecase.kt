package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.domain.repositories.SettingsRepository
import javax.inject.Inject

class ProfileUsecase @Inject constructor(
    private val profileRepository: SettingsRepository
) {
}
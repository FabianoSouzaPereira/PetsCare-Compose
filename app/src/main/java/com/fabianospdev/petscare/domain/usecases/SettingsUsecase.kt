package com.fabianospdev.petscare.domain.usecases

import com.fabianospdev.petscare.domain.repositories.SettingsRepository
import javax.inject.Inject

class SettingsUsecase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
}
package com.example.petscompose_class.domain.usecases

import com.example.petscompose_class.domain.repositories.SettingsRepository
import javax.inject.Inject

class SettingsUsecase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
}
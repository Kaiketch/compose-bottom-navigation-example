package com.redpond.user.repository

import com.redpond.domain.repository.UserRepository
import com.redpond.user.preferences.UserPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userPreferences: UserPreferences
) : UserRepository {

    override suspend fun fetchName(): Flow<String?> {
        return userPreferences.getName()
    }

    override suspend fun fetchCountryCode(): Flow<String?> {
        return userPreferences.getCountryCode()
    }

    override suspend fun updateName(name: String) {
        userPreferences.saveName(name)
    }

    override suspend fun updateCountryCode(code: String) {
        userPreferences.saveCountryCode(code)
    }
}

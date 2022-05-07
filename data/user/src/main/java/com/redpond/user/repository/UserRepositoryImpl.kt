package com.redpond.user.repository

import com.redpond.domain.User
import com.redpond.domain.repository.UserRepository
import com.redpond.user.preferences.UserPreferences
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userPreferences: UserPreferences
) : UserRepository {

    override suspend fun fetchMe(): User {
        val name = userPreferences.getName()
        val code = userPreferences.getCountryCode()
        return User(name = name, countryCode = code)
    }

    override suspend fun updateName(name: String) {
        userPreferences.saveName(name)
    }

    override suspend fun updateCountryCode(code: String) {
        userPreferences.saveCountryCode(code)
    }
}

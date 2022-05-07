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
        return User(name = name)
    }

    override suspend fun updateName(name: String) {
        userPreferences.saveName(name)
    }
}

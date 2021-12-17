package com.redpond.repository

import com.redpond.domain.User
import com.redpond.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {
    override fun fetchUser(id: Int): User {
        return User(
            id = id,
            name = "User"
        )
    }
}

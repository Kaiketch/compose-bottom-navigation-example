package com.redpond

import com.redpond.domain.User
import com.redpond.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {
    override fun fetchUser(id: Int): User {
        return User(
            id = id,
            name = "User"
        )
    }
}

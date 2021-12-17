package com.redpond.domain.repository

import com.redpond.domain.User

interface UserRepository {
    fun fetchUser(id: Int): User
}

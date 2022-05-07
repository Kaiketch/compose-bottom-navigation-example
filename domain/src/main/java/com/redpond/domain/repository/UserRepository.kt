package com.redpond.domain.repository

import com.redpond.domain.User

interface UserRepository {

    suspend fun fetchMe(): User

    suspend fun updateName(name: String)
}

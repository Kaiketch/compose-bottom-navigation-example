package com.redpond.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun fetchName(): Flow<String?>

    suspend fun fetchCountryCode(): Flow<String?>

    suspend fun updateName(name: String)

    suspend fun updateCountryCode(code: String)
}

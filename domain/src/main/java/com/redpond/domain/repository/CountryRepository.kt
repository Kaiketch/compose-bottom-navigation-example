package com.redpond.domain.repository

import com.redpond.domain.Country

interface CountryRepository {
    suspend fun fetchCountries(): List<Country>

    suspend fun fetchCountry(code: String): Country
}

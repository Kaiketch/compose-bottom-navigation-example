package com.redpond.domain.repository

import com.redpond.fragment.Country

interface CountryRepository {
    suspend fun fetchCountries(): List<Country>
}

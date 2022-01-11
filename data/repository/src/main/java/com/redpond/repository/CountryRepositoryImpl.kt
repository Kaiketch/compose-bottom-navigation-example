package com.redpond.repository

import com.redpond.api.CountryApi
import com.redpond.domain.User
import com.redpond.domain.repository.CountryRepository
import com.redpond.domain.repository.UserRepository
import com.redpond.fragment.Country
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryApi: CountryApi
) : CountryRepository {
    override suspend fun fetchCountries(): List<Country> {
        return countryApi.fetchCountries()
    }
}

package com.redpond.country.repository

import com.redpond.country.api.CountryApi
import com.redpond.domain.Country
import com.redpond.domain.repository.CountryRepository
import javax.inject.Inject

internal class CountryRepositoryImpl @Inject constructor(
    private val countryApi: CountryApi
) : CountryRepository {
    override suspend fun fetchCountries(): List<Country> {
        return countryApi.fetchCountries()
    }

    override suspend fun fetchCountry(code: String): Country {
        return countryApi.fetchCountry(code)
    }
}

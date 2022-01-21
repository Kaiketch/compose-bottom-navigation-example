package com.redpond

import com.redpond.api.CountryApi
import com.redpond.domain.repository.CountryRepository
import com.redpond.fragment.Country
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryApi: CountryApi
) : CountryRepository {
    override suspend fun fetchCountries(): List<Country> {
        return countryApi.fetchCountries()
    }

    override suspend fun fetchCountry(code: String): Country {
        return countryApi.fetchCountry(code)
    }
}

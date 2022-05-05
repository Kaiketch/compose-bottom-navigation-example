package com.redpond

import com.apollographql.apollo3.ApolloClient
import com.redpond.domain.Country
import javax.inject.Inject

internal class CountryApi @Inject constructor(
    private val apolloClient: ApolloClient
) {
    suspend fun fetchCountries(): List<Country> {
        val data = apolloClient.query(CountriesQuery()).execute().data
            ?: throw IllegalStateException("response data is null.")
        return data.countries.map { CountryMapper.map(it) }
    }

    suspend fun fetchCountry(code: String): Country {
        val data = apolloClient.query(CountryQuery(code)).execute().data?.country
            ?: throw IllegalStateException("response data is null.")
        return CountryMapper.map(data)
    }
}

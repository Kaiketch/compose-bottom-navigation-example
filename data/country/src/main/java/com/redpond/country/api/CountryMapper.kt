package com.redpond.country.api

import com.redpond.CountriesQuery
import com.redpond.CountryQuery
import com.redpond.domain.Country


object CountryMapper {
    fun map(country: CountryQuery.Country): Country =
        Country(
            country.code,
            country.name,
            country.capital,
            country.currency
        )

    fun map(country: CountriesQuery.Country): Country =
        Country(
            country.code,
            country.name,
        )
}

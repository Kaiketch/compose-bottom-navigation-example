package com.redpond

import com.redpond.domain.Country


object CountryMapper {
    fun map(country: CountryQuery.Country): Country =
        Country(
            country.code,
            country.name,
        )

    fun map(country: CountriesQuery.Country): Country =
        Country(
            country.code,
            country.name,
        )
}

package com.redpond.search

import com.google.common.truth.Truth.assertThat
import com.redpond.domain.Country
import com.redpond.domain.repository.CountryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    @MockK
    lateinit var countryRepository: CountryRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun textInit_success() = runTest {

        val list = listOf(
            Country("c1", "country1"),
            Country("c2", "country2"),
        )
        coEvery { countryRepository.fetchCountries() } returns list

        val viewModel = SearchViewModel(countryRepository)

        assertThat(viewModel.uiState.value.countries).isEqualTo(list)
        assertThat(viewModel.uiState.value.isLoading).isFalse()
    }
}

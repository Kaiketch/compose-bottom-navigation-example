package com.redpond.search

import com.redpond.domain.repository.CountryRepository
import com.redpond.fragment.Country
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class SearchViewModelTest {

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun textInit_success() = runTest{

        val countryRepository = mockk<CountryRepository>()
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

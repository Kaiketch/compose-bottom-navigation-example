package com.redpond.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redpond.domain.Country
import com.redpond.domain.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val countryRepository: CountryRepository,
) : ViewModel() {

    data class SearchUiState(
        val countries: List<Country> = emptyList(),
        val isLoading: Boolean = false,
    )

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState

    init {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                countryRepository.fetchCountries()
            }.onSuccess {
                _uiState.value = _uiState.value.copy(
                    countries = it,
                    isLoading = false
                )
            }.onFailure {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }
}

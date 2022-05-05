package com.redpond.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redpond.common.Args.Companion.CODE
import com.redpond.domain.Country
import com.redpond.domain.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val countryRepository: CountryRepository,
) : ViewModel() {

    data class DetailUiState(
        val country: Country? = null,
        val isLoading: Boolean = false,
    )

    private val code = savedStateHandle.get<String>(CODE)

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState

    init {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                countryRepository.fetchCountry(code.orEmpty())
            }.onSuccess {
                _uiState.value = _uiState.value.copy(
                    country = it,
                    isLoading = false
                )
            }.onFailure {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }
}

package com.redpond.base.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {

    data class UserUiState(
        val name: String = "",
    )

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState

    fun set(str: String) {
        _uiState.value = _uiState.value.copy(name = str)
    }
}

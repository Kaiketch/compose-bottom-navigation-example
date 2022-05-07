package com.redpond.base.viewmodel

import androidx.lifecycle.ViewModel
import com.redpond.domain.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {

    data class UserUiState(
        val user: User,
    )

    private val _uiState = MutableStateFlow(UserUiState(User(name = "")))
    val uiState: StateFlow<UserUiState> = _uiState

    fun set(str: String) {
        _uiState.value = _uiState.value.copy(user = User(name = str))
    }
}

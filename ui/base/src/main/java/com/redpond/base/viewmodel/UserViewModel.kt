package com.redpond.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redpond.domain.User
import com.redpond.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    data class UserUiState(
        val user: User,
        val isLoading: Boolean = false,
    )

    private val _uiState = MutableStateFlow(UserUiState(User(name = "")))
    val uiState: StateFlow<UserUiState> = _uiState

    init {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                userRepository.fetchMe()
            }.onSuccess { user ->
                _uiState.value = _uiState.value.copy(
                    user = user,
                    isLoading = false
                )
            }.onFailure {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }

    fun onUpdateNameClicked(name: String) {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                userRepository.updateName(name)
            }.mapCatching {
                userRepository.fetchMe()
            }.onSuccess { user ->
                _uiState.value = _uiState.value.copy(
                    user = user,
                    isLoading = false
                )
            }.onFailure {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }
}

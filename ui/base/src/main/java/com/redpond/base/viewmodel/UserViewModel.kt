package com.redpond.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redpond.domain.User
import com.redpond.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
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

    private val _uiState = MutableStateFlow(UserUiState(User()))
    val uiState: StateFlow<UserUiState> = _uiState

    init {
        viewModelScope.launch {
            combine(userRepository.fetchName(), userRepository.fetchCountryCode(), ::Pair)
                .onStart { _uiState.value = _uiState.value.copy(isLoading = true) }
                .catch { _uiState.value = _uiState.value.copy(isLoading = false) }
                .collect { (name, countryCode) ->
                    _uiState.value = _uiState.value.copy(
                        user = User(name = name, countryCode = countryCode),
                        isLoading = false
                    )
                }
        }
    }

    fun onUpdateNameClicked(name: String) {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                userRepository.updateName(name)
            }.onSuccess {
                _uiState.value = _uiState.value.copy(
                    user = _uiState.value.user.copy(name = name),
                    isLoading = false
                )
            }.onFailure {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }

    fun onUpdateCountryClicked(code: String?) {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                userRepository.updateCountryCode(requireNotNull(code))
            }.onSuccess {
                _uiState.value = _uiState.value.copy(
                    user = _uiState.value.user.copy(countryCode = code),
                    isLoading = false
                )
            }.onFailure {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }
}

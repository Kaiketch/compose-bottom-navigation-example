package com.redpond.profile

import androidx.lifecycle.ViewModel
import com.redpond.domain.User
import com.redpond.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    fun get(): User {
        return userRepository.fetchUser(1)
    }
}

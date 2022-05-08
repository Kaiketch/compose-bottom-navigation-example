package com.redpond.base.viewmodel

import com.google.common.truth.Truth.assertThat
import com.redpond.domain.User
import com.redpond.domain.repository.UserRepository
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class UserViewModelTest {

    @MockK
    lateinit var userRepository: UserRepository

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
    fun testInit_success() {
        val user = User(name = null, countryCode = null)
        coEvery { userRepository.fetchMe() } returns user
        val userViewModel = UserViewModel(userRepository)

        assertThat(userViewModel.uiState.value.user).isEqualTo(user)
        assertThat(userViewModel.uiState.value.isLoading).isFalse()
    }

    @Test
    fun testOnUpdateNameClicked_success() {
        val name = "name1"
        coEvery { userRepository.updateName(name) } just Runs
        val userViewModel = UserViewModel(userRepository)

        assertThat(userViewModel.uiState.value.user.name).isNull()

        userViewModel.onUpdateNameClicked(name)
        coVerify(exactly = 1) { userRepository.updateName(name) }

        assertThat(userViewModel.uiState.value.user.name).isEqualTo(name)
        assertThat(userViewModel.uiState.value.isLoading).isFalse()
    }

    @Test
    fun onUpdateCountryClicked() {
        val countryCode = "c1"
        coEvery { userRepository.updateCountryCode(countryCode) } just Runs
        val userViewModel = UserViewModel(userRepository)

        assertThat(userViewModel.uiState.value.user.countryCode).isNull()

        userViewModel.onUpdateCountryClicked(countryCode)
        coVerify(exactly = 1) { userRepository.updateCountryCode(countryCode) }

        assertThat(userViewModel.uiState.value.user.countryCode).isEqualTo(countryCode)
        assertThat(userViewModel.uiState.value.isLoading).isFalse()
    }
}

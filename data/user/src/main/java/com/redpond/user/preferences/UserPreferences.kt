package com.redpond.user.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class UserPreferences @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = USER_PREFERENCES
    )

    suspend fun saveName(name: String) {
        context.dataStore.edit { it[NAME] = name }
    }

    fun getName(): Flow<String?> {
        return context.dataStore.data.map { preferences -> preferences[NAME] }
    }

    suspend fun saveCountryCode(code: String) {
        context.dataStore.edit { it[COUNTRY_CODE] = code }
    }

    fun getCountryCode(): Flow<String?> {
        return context.dataStore.data.map { preferences -> preferences[COUNTRY_CODE] }
    }

    companion object {
        const val USER_PREFERENCES = "user_preferences"
        val NAME = stringPreferencesKey("name")
        val COUNTRY_CODE = stringPreferencesKey("country_code")
    }
}

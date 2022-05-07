package com.redpond.user.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
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

    suspend fun getName(): String {
        return context.dataStore.data.map { preferences -> preferences[NAME] }.firstOrNull()
            .orEmpty()
    }

    companion object {
        const val USER_PREFERENCES = "user_preferences"
        val NAME = stringPreferencesKey("name")
    }
}

package com.noureldin.githubrepositoryodcamit.data.data_source.local.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.PREFERENCES_IS_FIRST_TIME
import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.PREFERENCES_NAME
import kotlinx.coroutines.flow.first

class DataStorePreference(private val context: Context) {
    companion object {
        private object PreferenceKeys {
            val isFirstTimeKey = booleanPreferencesKey( PREFERENCES_IS_FIRST_TIME)
        }
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
            name = PREFERENCES_NAME
        )
    }

    suspend fun saveIsFirstTime(isFirstTime: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.isFirstTimeKey] = isFirstTime
        }
    }

    suspend fun readIsFirstTime(): Boolean = context.dataStore.data.first()[PreferenceKeys.isFirstTimeKey] ?: true

}
package com.redpond.country.repository

import com.redpond.domain.repository.CountryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CountryRepositoryModule {

    @Singleton
    @Binds
    internal abstract fun provideCountryRepository(repository: CountryRepositoryImpl): CountryRepository
}

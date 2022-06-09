package com.kouki.googlebooktest.di

import com.kouki.googlebooktest.data.repository.GoogleBookRepository
import com.kouki.googlebooktest.domain.use_cases.SearchBooksUseCase
import com.kouki.googlebooktest.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(googleBookRepository: GoogleBookRepository): UseCases{
        return UseCases(
            searchBooksUseCase = SearchBooksUseCase(googleBookRepository)
        )
    }
}
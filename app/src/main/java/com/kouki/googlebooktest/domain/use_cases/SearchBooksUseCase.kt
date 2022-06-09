package com.kouki.googlebooktest.domain.use_cases

import androidx.paging.PagingData
import com.kouki.googlebooktest.data.repository.GoogleBookRepository
import com.kouki.googlebooktest.domain.model.Items
import kotlinx.coroutines.flow.Flow

class SearchBooksUseCase(
    private val repository: GoogleBookRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Items>> {
        return repository.searchBooks(query = query)
    }
}
package com.kouki.googlebooktest.data.repository

import androidx.paging.PagingData
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoogleBookRepository @Inject constructor(
    private val remote: RemoteDataSource
) {
    fun searchBooks(query: String): Flow<PagingData<Items>>{
        return remote.searchBooks(query)
    }
}
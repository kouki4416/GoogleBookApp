package com.kouki.googlebooktest.domain.repository

import androidx.paging.PagingData
import com.kouki.googlebooktest.domain.model.BookDetail
import com.kouki.googlebooktest.domain.model.Books
import com.kouki.googlebooktest.domain.model.Items
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource {
    fun searchBooks(title:String): Flow<PagingData<Items>>
    suspend fun getBook(id: String): BookDetail?
}
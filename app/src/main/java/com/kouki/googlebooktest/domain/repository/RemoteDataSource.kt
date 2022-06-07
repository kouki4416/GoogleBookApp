package com.kouki.googlebooktest.domain.repository

import androidx.paging.PagingData
import com.kouki.googlebooktest.domain.model.Books
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource {
    fun getSearchedBooks(title:String, apiKey:String): Flow<Response<Books>>
}
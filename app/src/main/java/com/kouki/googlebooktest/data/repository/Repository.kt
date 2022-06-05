package com.kouki.googlebooktest.data.repository

import com.kouki.googlebooktest.data.remote.GoogleBookApi
import com.kouki.googlebooktest.domain.model.BookSearchResultData
import com.kouki.googlebooktest.domain.model.Books
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: Retrofit
){
    suspend fun getBooks(title: String, apiKey: String): Response<Books>{
        return retrofit.create(GoogleBookApi::class.java).getBooks(title, )
    }
}

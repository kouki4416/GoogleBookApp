package com.kouki.googlebooktest.data.remote

import com.kouki.googlebooktest.domain.model.Books
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBookApi {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") inTitle: String,
        @Query("startIndex") page: String
        //@Query("key") apiKey: String
    ): Response<Books>
}
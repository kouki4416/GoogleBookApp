package com.kouki.googlebooktest.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.ExperimentalPagingApi
import com.kouki.googlebooktest.data.remote.GoogleBookApi
import com.kouki.googlebooktest.domain.model.Books
import com.kouki.googlebooktest.domain.repository.RemoteDataSource

//@ExperimentalPagingApi
//class RemoteDataSourceImpl(
//    private val googleBookApi: GoogleBookApi,
////    private val bookDatabase: BookDatabase
//): RemoteDataSource {
////    private val bookDao = bookDatabase.bookDao()
//
//
//    val myResponse: MutableLiveData<Response<Books>> = MutableLiveData()
//
////    suspend fun getBooks(title:String, apiKey:String): Flow<Response<Books>> {
////
////    }
//
//}
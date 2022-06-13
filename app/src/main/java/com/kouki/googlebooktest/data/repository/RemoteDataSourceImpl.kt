package com.kouki.googlebooktest.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kouki.googlebooktest.Util.Constants.ITEMS_PER_PAGE
import com.kouki.googlebooktest.data.remote.GoogleBookApi
import com.kouki.googlebooktest.domain.model.BookDetail
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.domain.repository.RemoteDataSource
import com.kouki.googlebooktest.domain.repository.SearchBooksPagingSource
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val googleBookApi: GoogleBookApi,
//    private val bookDatabase: BookDatabase
) : RemoteDataSource {
    override fun searchBooks(title: String): Flow<PagingData<Items>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchBooksPagingSource(googleBookApi = googleBookApi, query = title)
            }
        ).flow
    }

    override suspend fun getBook(id: String): BookDetail? {
        return googleBookApi.getBook(id).body()
    }

}
package com.kouki.googlebooktest.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kouki.googlebooktest.domain.model.Items
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoogleBookRepository @Inject constructor(
    private val pagingSource: GoogleBookPagingSource
) {
    fun getBooks(): Flow<PagingData<Items>> {
        return Pager(
            PagingConfig(pageSize = 10, enablePlaceholders = false)
        ){
            pagingSource
        }.flow
    }
}
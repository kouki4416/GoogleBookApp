package com.kouki.googlebooktest.domain.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kouki.googlebooktest.data.remote.GoogleBookApi
import com.kouki.googlebooktest.domain.model.Items
import retrofit2.HttpException
import java.io.IOException
import java.util.stream.Collectors.toList
import javax.inject.Inject

class GoogleBookPagingSource @Inject constructor(
    private val googleBookApi: GoogleBookApi
) : PagingSource<String, Items>() {
    override suspend fun load(params: LoadParams<String>): LoadResult<String, Items> {
        return try {
            val response = googleBookApi.getBooks("flower")
            val listing = response.body()?.items
            LoadResult.Page(
                listing?.toList() ?: listOf(),
                null,
                null
            )
        }catch (exception: IOException){
            return LoadResult.Error(exception)
        } catch(exception: HttpException){
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<String, Items>): String? {
        TODO("Not yet implemented")
    }
}
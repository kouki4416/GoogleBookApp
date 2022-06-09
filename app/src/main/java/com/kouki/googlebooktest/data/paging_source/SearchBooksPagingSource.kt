package com.kouki.googlebooktest.domain.repository

import androidx.paging.*
import com.kouki.googlebooktest.data.remote.GoogleBookApi
import com.kouki.googlebooktest.domain.model.Items
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchBooksPagingSource @Inject constructor(
    private val googleBookApi: GoogleBookApi,
    private val query: String
) : PagingSource<String, Items>() {
    override suspend fun load(params: LoadParams<String>): LoadResult<String, Items> {
        return try {
            //TODO use api here
            val response = googleBookApi.searchBooks(query)
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
        return state.anchorPosition.toString()
    }
}
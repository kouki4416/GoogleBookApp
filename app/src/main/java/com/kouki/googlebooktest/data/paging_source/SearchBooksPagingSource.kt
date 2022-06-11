package com.kouki.googlebooktest.domain.repository

import android.util.Log
import androidx.paging.*
import com.kouki.googlebooktest.Util.Constants.ITEMS_PER_PAGE
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
) : PagingSource<Int, Items>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        return try {
            // Start refresh at page 1 if undefined
            val currentKey = params.key ?: 1
            val response = googleBookApi.searchBooks(query, currentKey.toString())
            val listing = response.body()?.items
            Log.d("", currentKey.toString())
            Log.d("", response.toString())
            Log.d("", listing.toString())
            LoadResult.Page(
                listing?.toList() ?: listOf(),
                null,
                nextKey = (currentKey + ITEMS_PER_PAGE).takeIf { _ -> listing != null }
            )
        }catch (exception: IOException){
            return LoadResult.Error(exception)
        } catch(exception: HttpException){
            return LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        TODO("Not yet implemented")
    }
}
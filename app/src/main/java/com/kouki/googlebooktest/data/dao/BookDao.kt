package com.kouki.googlebooktest.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kouki.googlebooktest.domain.model.BookSearchResultData
import kotlinx.serialization.descriptors.PrimitiveKind

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBook(books: BookSearchResultData)

    @Query("SELECT * FROM book_data ORDER BY id ASC")
    fun readAllData(): PagingSource<Int, BookSearchResultData>
}
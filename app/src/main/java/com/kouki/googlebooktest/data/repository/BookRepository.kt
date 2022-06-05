package com.kouki.googlebooktest.data.repository

import androidx.lifecycle.LiveData
import com.kouki.googlebooktest.data.dao.BookDao
import com.kouki.googlebooktest.domain.model.BookSearchResultData

class BookRepository(private val bookDao: BookDao) {

    //val readAllData: LiveData<List<BookSearchResultData>> = bookDao.readAllData()

    suspend fun addBook(book: BookSearchResultData) {
        bookDao.addBook(book)
    }

//    suspend fun deleteBook(book: BookSearchResultData) {
//        bookDao.deleteBook(book)
//    }
}
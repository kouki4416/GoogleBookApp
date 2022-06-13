package com.kouki.googlebooktest.domain.use_cases

import com.kouki.googlebooktest.data.repository.GoogleBookRepository
import com.kouki.googlebooktest.domain.model.BookDetail

class GetBookUseCase (
    private val repository: GoogleBookRepository
){
    suspend operator fun invoke(bookId: String): BookDetail?{
        return repository.getBook(bookId)
    }
}
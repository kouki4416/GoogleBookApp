package com.kouki.googlebooktest.domain.use_cases

data class UseCases(
    val searchBooksUseCase: SearchBooksUseCase,
    val getBookUseCase: GetBookUseCase
)
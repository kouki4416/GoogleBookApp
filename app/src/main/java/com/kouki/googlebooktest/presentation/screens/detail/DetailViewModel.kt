package com.kouki.googlebooktest.presentation.screens.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kouki.googlebooktest.Util.Constants.DETAILS_ARGUMENT_KEY
import com.kouki.googlebooktest.domain.model.BookDetail
import com.kouki.googlebooktest.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle // receive id
): ViewModel(){
    private val _selectedBook: MutableStateFlow<BookDetail?> = MutableStateFlow(null)
    val selectedBook: StateFlow<BookDetail?> = _selectedBook

    init{
        viewModelScope.launch(Dispatchers.IO){
            val bookId = savedStateHandle.get<String>(DETAILS_ARGUMENT_KEY)
            Log.d("bookId", "BookID:$bookId")
            _selectedBook.value = bookId?.let { useCases.getBookUseCase(bookId) }

        }
    }
}
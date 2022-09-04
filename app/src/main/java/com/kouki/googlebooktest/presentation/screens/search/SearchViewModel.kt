package com.kouki.googlebooktest.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kouki.googlebooktest.Util.Constants
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle // receive keyword
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedBooks = MutableStateFlow<PagingData<Items>>(PagingData.empty())
    val searchedBooks = _searchedBooks

    init {
        savedStateHandle.get<String>(Constants.SEARCH_ARGUMENT_KEY)?.let {
            searchBooks(it)
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    private fun searchBooks(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.searchBooksUseCase(query = query).cachedIn(viewModelScope).collect {
                _searchedBooks.value = it
            }
        }
    }
}

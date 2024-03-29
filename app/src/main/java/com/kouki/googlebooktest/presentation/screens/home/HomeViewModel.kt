package com.kouki.googlebooktest.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedBooks = MutableStateFlow<PagingData<Items>>(PagingData.empty())
    val searchedBooks = _searchedBooks

    fun updateSearchQuery(query: String){
        _searchQuery.value = query
    }

}

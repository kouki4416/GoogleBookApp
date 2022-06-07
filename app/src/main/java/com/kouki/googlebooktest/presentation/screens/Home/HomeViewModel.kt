package com.kouki.googlebooktest.presentation.screens.Home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kouki.googlebooktest.Util.Constants.API_KEY
import com.kouki.googlebooktest.data.repository.Repository
import com.kouki.googlebooktest.domain.model.Books
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.domain.repository.GoogleBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val googleBookRepository: GoogleBookRepository
): ViewModel() {
//    private val _myResponse: MutableState<Response<Books>?> = mutableStateOf(null)
//    val myResponse = _myResponse
//    init {
//        viewModelScope.launch{
//            _myResponse.value = getBooks()
//        }
//    }
    fun getBooks(): Flow<PagingData<Items>> {
        return googleBookRepository.getBooks().cachedIn(viewModelScope)
    }

}
package com.kouki.googlebooktest.presentation.screens.Home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kouki.googlebooktest.Util.Constants.API_KEY
import com.kouki.googlebooktest.data.repository.Repository
import com.kouki.googlebooktest.domain.model.Books
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
private val repository: Repository
): ViewModel() {
    private val _myResponse: MutableState<Response<Books>?>   = mutableStateOf(null)
    val myResponse = _myResponse
    init {
        viewModelScope.launch{
            _myResponse.value = getBooks()
        }
    }
    suspend fun getBooks(): Response<Books> {
        return repository.getBooks("search", API_KEY)
    }

}
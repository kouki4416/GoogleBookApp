package com.kouki.googlebooktest.presentation.screens.Home

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.kouki.googlebooktest.BuildConfig
import com.kouki.googlebooktest.Util.Constants.API_KEY
import com.kouki.googlebooktest.presentation.common.ListContent
import kotlinx.serialization.json.JsonNull.content

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
){
    val response by homeViewModel.myResponse
    var imageUrl:String? = null
    var title:String? = null

    if(response?.isSuccessful == true){
       imageUrl =  response!!.body()!!.items[0].volumeInfo?.imageLinks?.thumbnail.toString()
        title =  response!!.body()!!.items[0].volumeInfo?.title.toString()
    }
    Scaffold(
        topBar = {

        },
        content = {
            if(imageUrl != null && title != null){
                ListContent(url = imageUrl, title = title)
            }
        }
    )
}
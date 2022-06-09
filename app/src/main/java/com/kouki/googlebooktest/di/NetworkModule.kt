package com.kouki.googlebooktest.di

import androidx.paging.ExperimentalPagingApi
import com.kouki.googlebooktest.Util.Constants.BASE_URL
import com.kouki.googlebooktest.data.remote.GoogleBookApi
import com.kouki.googlebooktest.data.repository.GoogleBookRepository
import com.kouki.googlebooktest.data.repository.RemoteDataSourceImpl
import com.kouki.googlebooktest.domain.repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@ExperimentalSerializationApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS).build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        //val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGoogleBookApi(retrofit: Retrofit): GoogleBookApi {
        return retrofit.create(GoogleBookApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        googleBookApi:GoogleBookApi
    ): RemoteDataSource{
        return RemoteDataSourceImpl(
            googleBookApi
        )
    }

//    @Provides
//    @Singleton
//    fun provideGoogleBookRepository(): GoogleBookRepository {
//        return GoogleBookRepository()
//    }

//    @Provides
//    @Singleton
//    fun provideGoogleBookPagingDataSource(googleBookApi: GoogleBookApi): SearchBooksPagingSource{
//        return SearchBooksPagingSource(googleBookApi)
//    }
}
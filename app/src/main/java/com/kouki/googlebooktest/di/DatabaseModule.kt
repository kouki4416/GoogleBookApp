package com.kouki.googlebooktest.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

//    @Provides
//    @Singleton
//    fun provideDatabase(
//        @ApplicationContext context: Context
//    ): BookDatabase {
//        return Room.databaseBuilder(
//            context,
//            BookDatabase::class.java,
//            BOOK_DATABASE,
//        ).build()
//    }
}
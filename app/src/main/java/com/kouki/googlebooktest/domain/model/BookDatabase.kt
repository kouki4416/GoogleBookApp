package com.kouki.googlebooktest.domain.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kouki.googlebooktest.data.dao.BookDao

//@Database(entities = [BookSearchResultData::class], version = 1, exportSchema = false)
abstract class BookDatabase {//: RoomDatabase() {
    abstract fun bookDao(): BookDao

//    companion object{
//        @Volatile
//        var INSTANCE: BookDatabase? = null
//
//        fun getDatabase(context: Context): BookDatabase{
//            val tmpInstance = INSTANCE
//            if(tmpInstance != null){
//                return tmpInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    BookDatabase::class.java,
//                    "book_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
}
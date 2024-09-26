package com.o7services.androidkotlin10_12.recyclerpackage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [NotesEntity::class], version = 1, exportSchema = true)
abstract class NotesDatabase : RoomDatabase(){

    abstract fun notesInterface(): NotesInterface
    //static members and functions of the class
    companion object{
        private var notesDatabase : NotesDatabase?= null

        fun getInstance(context: Context): NotesDatabase{
            if(notesDatabase == null){
                notesDatabase = Room.databaseBuilder(context,
                    NotesDatabase::class.java,
                    "NotesDatabase")
                    .allowMainThreadQueries()
                    .build()
            }
            return notesDatabase!!
        }
    }
}
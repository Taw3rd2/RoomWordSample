package com.waldorfprogramming.roomwordsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Zeero on 6/6/2018 at 7:23 AM.
 */

// In this codelab you don't update the entities and the version numbers.
// When you modify the database schema,
// you'll need to update the version number and define how to handle migrations.
// For a sample, destroying and re-creating the database is a fine migration strategy.
// For a real app, you must implement a migration strategy.
// See Understanding migrations with Room.

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

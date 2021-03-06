package com.example.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cryptoapp.Crypto
import com.example.cryptoapp.database.CryptoDao

@Database(entities = [ Crypto::class ], version=3)
@TypeConverters(CryptoTypeConverters::class)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun cryptoDao(): CryptoDao
}

val migration_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Crypto ADD COLUMN suspect TEXT NOT NULL DEFAULT ''"
        )
    }
}
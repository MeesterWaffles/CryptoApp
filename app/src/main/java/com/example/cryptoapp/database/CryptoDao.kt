package com.example.cryptoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.cryptoapp.Crypto
import java.util.*

@Dao
interface CryptoDao {

    @Query("SELECT * FROM CRYPTO")
    fun getCryptos(): LiveData<List<Crypto>>

    @Query("SELECT * FROM CRYPTO WHERE id=(:id)")
    fun getCryptos(id: UUID): LiveData<Crypto?>
}
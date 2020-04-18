package com.example.cryptoapp
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Crypto(@PrimaryKey val id: UUID = UUID.randomUUID(),
                  var cryptoName: String = "",
                  var price: Double = 0.0)
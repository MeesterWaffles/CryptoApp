package com.example.cryptoapp
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Crypto(@PrimaryKey val pk: UUID = UUID.randomUUID(),
                  var id: String = "default",
                  var symbol: String = "default",
                  var cryptoName: String = "default",
                  var image_string_URL: String = "default",
                  var price: String = "default",
                  var marketCap: String = "default",
                  var market_cap_rank: String = "default",
                  var total_volume: String = "default",
                  var high_24h: String = "default",
                  var low_24h: String = "default",
                  var price_change_24h: String = "default",
                  var price_change_percentage_24h: String = "default",
                  var ath: String = "default",
                  var ath_change_percentage: String = "default",
                  var ath_date: String = "default",
                  var last_updated: String = "default")
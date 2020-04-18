package com.example.cryptoapp

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.coingecko.constant.Currency
import com.example.cryptoapp.coingecko.domain.Coins.CoinList
import com.example.cryptoapp.coingecko.impl.CoinGeckoApiClientImpl

class CryptoListViewModel : ViewModel() {

    //private val client =  CoinGeckoApiClientImpl()
    val cryptos = mutableListOf<Crypto>()
    //private val cryptoList: MutableList<CoinList> = client.coinList

    init {
        for (i in 0 until 100) {
            val crypto = Crypto()
            val name = "$i"
                // cryptoList[0].toString()
            crypto.cryptoName = "Name: $name"
            crypto.price = 0.0
            cryptos += crypto
        }
    }
}
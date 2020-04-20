package com.example.cryptoapp

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.coingecko.impl.CoinGeckoApiClientImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class CryptoListViewModel : ViewModel() {

    val cryptos = mutableListOf<Crypto>()

    init {
        Single.fromCallable {
            // Here, we load the coin list from the CoinGecko API
            val client = CoinGeckoApiClientImpl()
            Log.d("*****CoinGecko*****", client.ping().toString())
            return@fromCallable client.coinList
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { cryptoList ->
                // And then we display it.
                for (i in 0 until 100) {
                    val crypto = Crypto()
                    //val num = "$i"
                    crypto.cryptoName = cryptoList[i].name.toString()
                    crypto.price = 69.0
                    cryptos += crypto
                }
                Log.d("*****CRYPTO*****","# Of Cryptos In Data Structure: ${cryptos.size}")
            }
    }
}
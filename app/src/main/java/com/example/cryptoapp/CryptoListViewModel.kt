package com.example.cryptoapp

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.coingecko.impl.CoinGeckoApiClientImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

import org.json.JSONArray

class CryptoListViewModel : ViewModel() {

    var cryptos = mutableListOf<Crypto>()

    init {
        //Multithreading
        Single.fromCallable {
            //Instantiate CoinGeckoAPI Client
            val client = CoinGeckoApiClientImpl()

            //Ping to make sure client is responding
            Log.d("*****CoinGecko*****", client.ping().toString())

            // Here, we load the coin list from the CoinGecko API
            val list = client.coinList

            println(list)

            //Here, we make our own list
            val cryptoList = mutableListOf<Crypto>()

            //Get response from client
            val response = client.getCoinMarkets("usd")
            Log.d("*coingecko*", response.toString())


            //Iterate over cryptos and add to data structure
            (0..99).forEach { index ->
                val crypto = Crypto()
                if (!response[index].toString().isNullOrBlank())
                {
                    crypto.id = response[index].id
                    crypto.symbol = response[index].symbol
                    crypto.cryptoName = response[index].name
                    crypto.image_string_URL = response[index].image
                    crypto.price = response[index].currentPrice.toString()
                    crypto.marketCap = response[index].marketCap.toString()
                    crypto.market_cap_rank = response[index].marketCapRank.toString()
                    crypto.total_volume = response[index].totalVolume.toString()
                    crypto.high_24h = response[index].high24h.toString()
                    crypto.low_24h = response[index].low24h.toString()
                    crypto.price_change_24h = response[index].priceChange24h.toString()
                    crypto.price_change_percentage_24h = response[index].priceChangePercentage24h.toString()
                    crypto.ath = response[index].ath.toString()
                    crypto.ath_change_percentage = response[index].athChangePercentage.toString()
                    crypto.ath_date = response[index].athDate.toString()
                    crypto.last_updated = response[index].lastUpdated.toString()
                    cryptoList += crypto
                }
            }
            //Return data structure
            return@fromCallable cryptoList
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { cryptoList ->
                //Set local data structure to multithreaded return data structure
                cryptos = cryptoList
                Log.d("*****CRYPTO*****","# Of Cryptos In Data Structure: ${cryptos.size}")
            }
    }
}
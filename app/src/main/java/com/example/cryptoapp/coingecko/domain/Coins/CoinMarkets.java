package com.example.cryptoapp.coingecko.domain.Coins;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.cryptoapp.coingecko.domain.Coins.CoinData.Roi;
import com.example.cryptoapp.coingecko.domain.Coins.CoinData.SparklineIn7d;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinMarkets
{
    @JsonProperty("id")
    public String id;
    @JsonProperty("symbol")
    public String symbol;
    @JsonProperty("name")
    public String name;
    @JsonProperty("image")
    public String image;
    @JsonProperty("current_price")
    public long currentPrice;
    @JsonProperty("market_cap")
    public long marketCap;
    @JsonProperty("market_cap_rank")
    public long marketCapRank;
    @JsonProperty("total_volume")
    public long totalVolume;
    @JsonProperty("high_24h")
    public long high24h;
    @JsonProperty("low_24h")
    public long low24h;
    @JsonProperty("price_change_24h")
    public double priceChange24h;
    @JsonProperty("price_change_percentage_24h")
    public double priceChangePercentage24h;
    @JsonProperty("market_cap_change_24h")
    public long marketCapChange24h;
    @JsonProperty("market_cap_change_percentage_24h")
    public double marketCapChangePercentage24h;
    @JsonProperty("circulating_supply")
    public long circulatingSupply;
    @JsonProperty("total_supply")
    public long totalSupply;
    @JsonProperty("ath")
    public long ath;
    @JsonProperty("ath_change_percentage")
    public double athChangePercentage;
    @JsonProperty("ath_date")
    public String athDate;
    @JsonProperty("roi")
    public Roi roi;
    @JsonProperty("last_updated")
    public String lastUpdated;
    @JsonProperty("sparkline_in_7d")
    public SparklineIn7d sparklineIn7d;
    @JsonProperty("price_change_percentage_1h_in_currency")
    public double priceChangePercentage1hInCurrency;

}


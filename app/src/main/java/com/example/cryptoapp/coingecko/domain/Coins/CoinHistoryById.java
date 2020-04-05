package com.example.cryptoapp.coingecko.domain.Coins;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.cryptoapp.coingecko.domain.Coins.CoinData.*;
import com.example.cryptoapp.coingecko.domain.Shared.Image;
import com.example.cryptoapp.coingecko.domain.Shared.Ticker;
import com.example.cryptoapp.coingecko.domain.Status.StatusUpdates;
import lombok.*;

import java.util.Map;

@Data
public class CoinHistoryById {
    @JsonProperty("id")
    private String id;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("localization")
    private Map<String, String> localization;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("market_data")
    private MarketData marketData;
    @JsonProperty("community_data")
    private CommunityData communityData;
    @JsonProperty("developer_data")
    private DeveloperData developerData;
    @JsonProperty("public_interest_stats")
    private PublicInterestStats publicInterestStats;

}

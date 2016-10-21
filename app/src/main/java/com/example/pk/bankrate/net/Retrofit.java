package com.example.pk.bankrate.net;

import com.example.pk.bankrate.models.BankRateModel;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

public class Retrofit {
    private static String BASE_URL = "http://resources.finance.ua/";
    private static BankRateApi bankRateApi;

    static {
        initialize();
    }

    private interface BankRateApi {
        @GET("/ru/public/currency-cash.json")
        void getBankRate(Callback<BankRateModel> callback);
    }

    private static void initialize() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        bankRateApi = restAdapter.create(BankRateApi.class);
    }

    public static void getBankRate(Callback<BankRateModel> callback) {
        bankRateApi.getBankRate(callback);
    }
}

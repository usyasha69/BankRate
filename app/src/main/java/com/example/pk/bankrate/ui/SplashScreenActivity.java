package com.example.pk.bankrate.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.pk.bankrate.R;
import com.example.pk.bankrate.models.BankRateModel;
import com.example.pk.bankrate.net.Retrofit;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashScreenActivity extends Activity {
    public static final String BANK_RATE_KEY = "bank rate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.splashScreenTheme);
        setContentView(R.layout.activity_splash_screen);

        Retrofit.getBankRate(new Callback<BankRateModel>() {
            @Override
            public void success(BankRateModel bankRateModel, Response response) {
                startActivity(new Intent(SplashScreenActivity.this, BankRateActivity.class)
                        .putExtra(BANK_RATE_KEY, removeBanks(bankRateModel)));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private BankRateModel removeBanks(BankRateModel bankRateModel) {
        final int BANKS_REMOVE_NUMBER = 1630;

        for (int i = 0; i < BANKS_REMOVE_NUMBER; i++) {
            int randomBankIndex = (int) (Math.random() * bankRateModel.organizations.size());

            bankRateModel.organizations.remove(randomBankIndex);
        }

        return bankRateModel;
    }
}

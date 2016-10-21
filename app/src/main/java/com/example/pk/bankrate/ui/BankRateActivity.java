package com.example.pk.bankrate.ui;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.pk.bankrate.R;
import com.example.pk.bankrate.adapters.RVAdapter;
import com.example.pk.bankrate.models.BankRateModel;
import com.example.pk.bankrate.utils.ProfitablyBankFounder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankRateActivity extends AppCompatActivity {
    @BindView(R.id.bra_banks_rv)
    RecyclerView banks;
    @BindView(R.id.bra_recommended_banks)
    TextView recommendedBanks;

    private BankRateModel bankRateModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_rate);
        ButterKnife.bind(this);

        bankRateModel = (BankRateModel) getIntent().getSerializableExtra(SplashScreenActivity.BANK_RATE_KEY);

        RVAdapter rvAdapter = new RVAdapter(this, bankRateModel);
        rvAdapter.setOnItemClickListener(new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BankRateModel.Organization organization, int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BankRateActivity.this)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle("Bank information")
                        .setCancelable(true)
                        .setMessage("Bank name: " + organization.title + "\nCurrency: "
                                + organization.currencies.toString());

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        banks.setLayoutManager(new LinearLayoutManager(this));
        banks.setAdapter(rvAdapter);
        setProfitablyBanks();
    }

    private void setProfitablyBanks() {
        recommendedBanks.setText(new ProfitablyBankFounder().profitablyBanksToString(bankRateModel));
    }
}

package com.example.pk.bankrate.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class BankRateModel implements Serializable {
    public ArrayList<Organization> organizations;

    public static class Organization implements Serializable {
        public String title;
        public Currency currencies;

        public static class Currency implements Serializable {
            @SerializedName("EUR")
            public Eur eur;
            @SerializedName("RUB")
            public Rub rub;
            @SerializedName("USD")
            public Usd usd;

            @Override
            public String toString() {
                return "\neur: " + eur +
                        ";\nrub: " + rub +
                        ";\nusd: " + usd;
            }

            public static class Eur implements Serializable {
                @SerializedName("ask")
                public String ask;
                @SerializedName("bid")
                public String bid;

                @Override
                public String toString() {
                    return "sale='" + ask + '\'' +
                            ", buy='" + bid + '\'';
                }
            }

            public static class Rub implements Serializable {
                @SerializedName("ask")
                public String ask;
                @SerializedName("bid")
                public String bid;

                @Override
                public String toString() {
                    return "sale='" + ask + '\'' +
                            ", buy='" + bid + '\'';
                }
            }

            public static class Usd implements Serializable {
                @SerializedName("ask")
                public String ask;
                @SerializedName("bid")
                public String bid;

                @Override
                public String toString() {
                    return "sale='" + ask + '\'' +
                            ", buy='" + bid + '\'';
                }
            }
        }
    }
}

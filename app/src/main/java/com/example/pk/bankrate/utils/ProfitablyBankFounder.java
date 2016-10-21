package com.example.pk.bankrate.utils;

import com.example.pk.bankrate.models.BankRateModel;

public class ProfitablyBankFounder {
    /**
     * This method found bank with profitably EUR sale.
     *
     * @param bankRateModel - bank rate model
     * @return - bank rate model
     */
    public BankRateModel.Organization foundProfitablyEURSale(BankRateModel bankRateModel) {
        final int START_MIN_POSITION = 0;

        int minEURSaleIndex = 0;
        double minEURSale =
                Double.parseDouble(bankRateModel.organizations.get(START_MIN_POSITION).currencies.eur.ask);

        for (int i = 0; i < bankRateModel.organizations.size(); i++) {
            double EURSale = Double.parseDouble(bankRateModel.organizations.get(i).currencies.eur.ask);

            if (minEURSale > EURSale) {
                minEURSale = EURSale;
                minEURSaleIndex = i;
            }
        }

        return bankRateModel.organizations.get(minEURSaleIndex);
    }

    /**
     * This method found bank with profitably EUR buy.
     *
     * @param bankRateModel - bank rate model
     * @return - bank rate model
     */
    public BankRateModel.Organization foundProfitablyEURBuy(BankRateModel bankRateModel) {
        final int START_MAX_POSITION = 0;

        int maxEURBuyIndex = 0;
        double maxEURBuy =
                Double.parseDouble(bankRateModel.organizations.get(START_MAX_POSITION).currencies.eur.bid);

        for (int i = 0; i < bankRateModel.organizations.size(); i++) {
            double EURBuy = Double.parseDouble(bankRateModel.organizations.get(i).currencies.eur.bid);

            if (maxEURBuy < EURBuy) {
                maxEURBuy = EURBuy;
                maxEURBuyIndex = i;
            }
        }

        return bankRateModel.organizations.get(maxEURBuyIndex);
    }

    /**
     * This method found bank with profitably RUB sale.
     *
     * @param bankRateModel - bank rate model
     * @return - bank rate model
     */
    public BankRateModel.Organization foundProfitablyRUBSale(BankRateModel bankRateModel) {
        final int START_MIN_POSITION = 0;

        int minRUBSaleIndex = 0;
        double minRUBSale =
                Double.parseDouble(bankRateModel.organizations.get(START_MIN_POSITION).currencies.rub.ask);

        for (int i = 0; i < bankRateModel.organizations.size(); i++) {
            double EURSale = Double.parseDouble(bankRateModel.organizations.get(i).currencies.rub.ask);

            if (minRUBSale > EURSale) {
                minRUBSale = EURSale;
                minRUBSaleIndex = i;
            }
        }

        return bankRateModel.organizations.get(minRUBSaleIndex);
    }

    /**
     * This method found bank with profitably RUB buy.
     *
     * @param bankRateModel - bank rate model
     * @return - bank rate model
     */
    public BankRateModel.Organization foundProfitablyRUBBuy(BankRateModel bankRateModel) {
        final int START_MAX_POSITION = 0;

        int maxRUBBuyIndex = 0;
        double maxRUBBuy =
                Double.parseDouble(bankRateModel.organizations.get(START_MAX_POSITION).currencies.rub.bid);

        for (int i = 0; i < bankRateModel.organizations.size(); i++) {
            double RUBBuy = Double.parseDouble(bankRateModel.organizations.get(i).currencies.rub.bid);

            if (maxRUBBuy < RUBBuy) {
                maxRUBBuy = RUBBuy;
                maxRUBBuyIndex = i;
            }
        }

        return bankRateModel.organizations.get(maxRUBBuyIndex);
    }

    /**
     * This method found bank with profitably USD sale.
     *
     * @param bankRateModel - bank rate model
     * @return - bank rate model
     */
    public BankRateModel.Organization foundProfitablyUSDSale(BankRateModel bankRateModel) {
        final int START_MIN_POSITION = 0;

        int minUSDSaleIndex = 0;
        double minEURSale =
                Double.parseDouble(bankRateModel.organizations.get(START_MIN_POSITION).currencies.usd.ask);

        for (int i = 0; i < bankRateModel.organizations.size(); i++) {
            double USDSale = Double.parseDouble(bankRateModel.organizations.get(i).currencies.usd.ask);

            if (minEURSale > USDSale) {
                minEURSale = USDSale;
                minUSDSaleIndex = i;
            }
        }

        return bankRateModel.organizations.get(minUSDSaleIndex);
    }

    /**
     * This method found bank with profitably USD buy.
     *
     * @param bankRateModel - bank rate model
     * @return - bank rate model
     */
    public BankRateModel.Organization foundProfitablyUSDBuy(BankRateModel bankRateModel) {
        final int START_MAX_POSITION = 0;

        int maxUSDBuyIndex = 0;
        double maxUSDBuy =
                Double.parseDouble(bankRateModel.organizations.get(START_MAX_POSITION).currencies.usd.bid);

        for (int i = 0; i < bankRateModel.organizations.size(); i++) {
            double USDBuy = Double.parseDouble(bankRateModel.organizations.get(i).currencies.usd.bid);

            if (maxUSDBuy < USDBuy) {
                maxUSDBuy = USDBuy;
                maxUSDBuyIndex = i;
            }
        }

        return bankRateModel.organizations.get(maxUSDBuyIndex);
    }

    public String profitablyBanksToString(BankRateModel bankRateModel) {
        BankRateModel.Organization profitablyEURSaleBank = foundProfitablyEURSale(bankRateModel);
        BankRateModel.Organization profitablyEURBuyBank = foundProfitablyEURBuy(bankRateModel);

        BankRateModel.Organization profitablyRUBSaleBank = foundProfitablyRUBSale(bankRateModel);
        BankRateModel.Organization profitablyRUBBuyBank = foundProfitablyRUBBuy(bankRateModel);

        BankRateModel.Organization profitablyUSDSaleBank = foundProfitablyUSDSale(bankRateModel);
        BankRateModel.Organization profitablyUSDBuyBank = foundProfitablyUSDBuy(bankRateModel);

        return profitablyEURSaleBank.title.toUpperCase() + ": min EUR sale="
                + profitablyEURSaleBank.currencies.eur.ask + "\n"
                + profitablyEURBuyBank.title.toUpperCase() + ": max EUR buy="
                + profitablyEURBuyBank.currencies.eur.bid + "\n"
                + profitablyRUBSaleBank.title.toUpperCase() + ": min RUB sale="
                + profitablyEURSaleBank.currencies.rub.ask + "\n"
                + profitablyRUBBuyBank.title.toUpperCase() + ": max RUB buy="
                + profitablyEURSaleBank.currencies.rub.bid + "\n"
                + profitablyUSDSaleBank.title.toUpperCase() + ": min USD sale="
                + profitablyEURSaleBank.currencies.usd.ask + "\n"
                + profitablyUSDBuyBank.title.toUpperCase() + ": max USD buy="
                + profitablyEURSaleBank.currencies.usd.bid;
    }
}

package com.iCo6.system;

import com.iCo6.Constants;
import java.util.UUID;

import me.xanium.gemseconomy.api.GemsEconomyAPI;
import me.xanium.gemseconomy.currency.Currency;
import org.bukkit.Bukkit;

public class Holdings {
    private final UUID uuid;
    private final GemsEconomyAPI api = new GemsEconomyAPI();
    private final Currency currency = api.getCurrency(Constants.Nodes.Currency.toString());

    public Holdings(String name) {
        this.uuid = Bukkit.getOfflinePlayer(name).getUniqueId();
    }

    public Double getBalance() {
        return api.getBalance(uuid,currency);
    }

    public void add(double amount) {
        api.deposit(uuid,amount,currency);
    }

    public void subtract(double amount) {
        api.withdraw(uuid,amount,currency);
    }
}
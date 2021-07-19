package com.iCo6;

import java.io.File;

import com.iCo6.util.Common;

import me.xanium.gemseconomy.api.GemsEconomyAPI;
import me.xanium.gemseconomy.currency.Currency;
import org.bukkit.plugin.java.JavaPlugin;

public class iConomy extends JavaPlugin {
    public static File directory;

    public void onEnable() {
        // Plugin directory setup
        File directory = getDataFolder();
        if(!directory.exists()) directory.mkdir();

        // Extract Files
        Common.extract("Config.yml");

        // Setup Configuration
        Constants.load(new File(directory, "Config.yml"));
    }

    public void onDisable() {

    }

    public static String format(double amount) {
        GemsEconomyAPI api = new GemsEconomyAPI();
        Currency currency = api.getCurrency(Constants.Nodes.Currency.toString());
        return currency.format(amount);
    }
}

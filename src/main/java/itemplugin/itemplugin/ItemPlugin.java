package itemplugin.itemplugin;

import itemplugin.itemplugin.BasicItem.BasicItem;
import itemplugin.itemplugin.DescriptionItem.DescriptionItem;
import itemplugin.itemplugin.EnchantItem.EnchantItem;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        // When Plugin First Enables, Log To Console
        System.out.println("[ Item Plugin ] The Item Plugin Has Been Enabled");

        // Register Basic Item Command
        getCommand("basic").setExecutor(new BasicItem());

        // Register Description Item Command
        getCommand("description").setExecutor(new DescriptionItem());

        // Register Enchanted Item Command
        getCommand("enchanted").setExecutor(new EnchantItem());

    }

    @Override
    public void onDisable() {

        // When Plugin Shutdowns, Log To Console
        System.out.println("[ Item Plugin ] The Item Plugin Has Been Shutdown");

    }
}

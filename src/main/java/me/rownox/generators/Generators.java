package me.rownox.generators;

import me.rownox.generators.Events.BlockBreakEvent;
import me.rownox.generators.Events.BlockPlaceEvent;
import me.rownox.generators.Events.ItemPickupEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Generators extends JavaPlugin {

    public static Generators instance;
    public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {

        instance = this;

        getServer().getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemPickupEvent(), this);

        config.addDefault("Vault: ", true);
        config.addDefault("Amount: ", 10);
        config.options().copyDefaults(true);
        saveConfig();

    }

    @Override
    public void onDisable() {

        this.saveDefaultConfig();

    }

    public static Generators getInstance(){
        return instance;
    }
}

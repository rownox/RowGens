package me.rownox.generators;

import me.rownox.generators.Events.*;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;

import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.plugin.RegisteredServiceProvider;

public final class Generators extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    public static Generators instance;
    public FileConfiguration config = this.getConfig();

    public static HashMap<Material, Integer> gens = new HashMap<>();

    @Override
    public void onEnable() {

        instance = this;

        getServer().getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemPickupEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        config.addDefault("Amount: ", 10);
        config.options().copyDefaults(true);
        saveConfig();

        gens.put(Material.WHITE_STAINED_GLASS, 200);
        gens.put(Material.CYAN_STAINED_GLASS, 180);
        gens.put(Material.RED_STAINED_GLASS, 160);
        gens.put(Material.LIME_STAINED_GLASS, 140);
        gens.put(Material.PURPLE_STAINED_GLASS, 120);

        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }

    @Override
    public void onDisable() {

        this.saveDefaultConfig();
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Generators getInstance(){
        return instance;
    }


}

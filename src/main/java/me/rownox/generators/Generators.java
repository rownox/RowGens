package me.rownox.generators;

import me.rownox.generators.Events.*;
import me.rownox.generators.Utils.Generator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public final class Generators extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    public static Generators instance;
    public FileConfiguration config = this.getConfig();

    public static final List<Generator> generators = new ArrayList<>(Arrays.asList(
            new Generator(200, 100, "Tier I", Material.WHITE_STAINED_GLASS),
            new Generator(180, 300, "Tier II", Material.CYAN_STAINED_GLASS),
            new Generator(160, 500, "Tier III", Material.RED_STAINED_GLASS),
            new Generator(140, 700, "Tier IV", Material.LIME_STAINED_GLASS),
            new Generator(120, 900, "Tier V", Material.PURPLE_STAINED_GLASS)
    ));

    @Override
    public void onEnable() {
        instance = this;

        registerListener(new BlockPlaceEvent());
        registerListener(new BlockBreakEvent());
        registerListener(new ItemPickupEvent());
        registerListener(new PlayerInteractEvent());
        registerListener(new InventoryClick());

        config.addDefault("amount", 10);
        config.options().copyDefaults(true);
        saveConfig();

        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    public void registerListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
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

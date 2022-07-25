package me.rownox.generators;

import me.rownox.generators.Events.BlockBreakEvent;
import me.rownox.generators.Events.BlockPlaceEvent;
import me.rownox.generators.Events.ItemPickupEvent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Generators extends JavaPlugin {

    public static Generators instance;
    public FileConfiguration config = this.getConfig();

    public static HashMap<Material, Integer> gens = new HashMap<>();

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

        gens.put(Material.WHITE_STAINED_GLASS, 200);
        gens.put(Material.CYAN_STAINED_GLASS, 180);
        gens.put(Material.RED_STAINED_GLASS, 160);
        gens.put(Material.LIME_STAINED_GLASS, 140);
        gens.put(Material.PURPLE_STAINED_GLASS, 120);

    }

    @Override
    public void onDisable() {

        this.saveDefaultConfig();

    }

    public static Generators getInstance(){
        return instance;
    }
}

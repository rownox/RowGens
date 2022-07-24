package me.rownox.generators;

import org.bukkit.plugin.java.JavaPlugin;

public final class Generators extends JavaPlugin {

    public static Generators instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Generators getInstance(){
        return instance;
    }
}

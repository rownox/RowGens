package me.rownox.generators.Utils;

import org.bukkit.Material;

public class Generator {
    private int time;
    private int cost;
    private String tier;
    private Material mat;

    /**
     * Creates a Generator
     * @param time Cooldown time in ticks
     * @param cost Cost to aquire the generator
     * @param tier Tier of the generator
     * @param mat Material of the generator
     */
    public Generator(int time, int cost, String tier, Material mat) {
        this.time = time;
        this.cost = cost;
        this.tier = tier;
        this.mat = mat;
    }

    public int getTime() {
        return time;
    }

    public int getCost() {
        return cost;
    }

    public String getTier() {
        return tier;
    }

    public Material getMat() {
        return mat;
    }
}

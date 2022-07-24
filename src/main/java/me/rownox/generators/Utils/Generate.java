package me.rownox.generators.Utils;

import me.rownox.generators.Generators;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

public class Generate {

    public static void generate(Player p, int time, int X, int Y, int Z) {
        ItemStack coin = new ItemStack(Material.SUNFLOWER);
        World w = p.getWorld();
        new BukkitRunnable(){
            @Override
            public void run() {
                Item i = Objects.requireNonNull(w).dropItem(new Location(w, X + 0.5, Y + 1, Z + 0.5), coin);
                i.setVelocity(new Vector(0, 0, 0));
            }
        }.runTaskTimer(Generators.getInstance(), 0, time);
    }
}

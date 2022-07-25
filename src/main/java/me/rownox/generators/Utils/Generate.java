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

    public static void generate(Player p, int time, Location loc, String tier) {

        int X = loc.getBlockX();
        int Y = loc.getBlockY();
        int Z = loc.getBlockZ();
        World w = p.getWorld();
        ItemStack coin = new ItemStack(Material.SUNFLOWER);

        p.sendMessage(ChatColor.GREEN + "You placed a " + tier + ChatColor.GREEN + " generator.");

        new BukkitRunnable(){
            @Override
            public void run() {
                Item i = Objects.requireNonNull(w).dropItem(new Location(w, X + 0.5, Y + 1, Z + 0.5), coin);
                i.setVelocity(new Vector(0, 0, 0));
            }
        }.runTaskTimer(Generators.getInstance(), time, time);
    }
}

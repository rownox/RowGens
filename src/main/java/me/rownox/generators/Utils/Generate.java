package me.rownox.generators.Utils;

import me.rownox.generators.Generators;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

import static me.rownox.generators.Generators.*;

public final class Generate {

    public static void generate(Player p, int time, Location loc) {

        int X = loc.getBlockX();
        int Y = loc.getBlockY();
        int Z = loc.getBlockZ();
        World w = p.getWorld();
        ItemStack coin = new ItemStack(Material.SUNFLOWER);

        p.sendMessage(ChatColor.GREEN + "You placed a generator.");

        new BukkitRunnable(){
            @Override
            public void run() {
                for (Generator generator : generators) {
                    if (generator.getMat() == loc.getBlock().getType()) {
                        Item i = Objects.requireNonNull(w).dropItem(new Location(w, X + 0.5, Y + 1, Z + 0.5), coin);
                        i.setVelocity(new Vector(0, 0, 0));
                    }
                }
            }
        }.runTaskTimer(Generators.getInstance(), time, time);
    }

    public static void sellGlass(Player p, int price) {
        Block b = p.getTargetBlock(null, 10);
        if (getEconomy().has(p, price)) {
            getEconomy().withdrawPlayer(p, price);
            p.sendMessage(ChatColor.GREEN + "You upgraded your generator.");
            SoundUtils.playSound(p, Sound.BLOCK_NOTE_BLOCK_PLING);

            // Not sure if this is intentional rownox, but they all upgrade to CYAN_STAINED_GLASS
            if (b.getType().equals(Material.WHITE_STAINED_GLASS)) {
                b.setType(Material.CYAN_STAINED_GLASS);
            } else if (b.getType().equals(Material.CYAN_STAINED_GLASS)) {
                b.setType(Material.CYAN_STAINED_GLASS);
            } else if (b.getType().equals(Material.RED_STAINED_GLASS)) {
                b.setType(Material.CYAN_STAINED_GLASS);
            } else if (b.getType().equals(Material.LIME_STAINED_GLASS)) {
                b.setType(Material.CYAN_STAINED_GLASS);
            } else if (b.getType().equals(Material.PURPLE_STAINED_GLASS)) {
                b.setType(Material.CYAN_STAINED_GLASS);
            }
        } else {
            p.sendMessage(ChatColor.RED + "You don't have enough money to upgrade.");
            SoundUtils.endermanSound(p);
        }
    }
}

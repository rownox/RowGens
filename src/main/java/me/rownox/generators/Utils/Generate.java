package me.rownox.generators.Utils;

import me.rownox.generators.Generators;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Objects;

import static me.rownox.generators.Generators.gens;
import static me.rownox.generators.Generators.getEconomy;

public class Generate {

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
                if (gens.containsKey(loc.getBlock().getType())) {
                    Item i = Objects.requireNonNull(w).dropItem(new Location(w, X + 0.5, Y + 1, Z + 0.5), coin);
                    i.setVelocity(new Vector(0, 0, 0));
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Generators.getInstance(), time, time);
    }

    public static void sellGlass(Player p, int price) {
        Block b = p.getTargetBlock(null, 10);
        if (getEconomy().has(p, price)) {
            getEconomy().withdrawPlayer(p, price);
            p.sendMessage(ChatColor.GREEN + "You upgraded your generator.");
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
            if (b.getType().equals(Material.WHITE_STAINED_GLASS)) {
                b.setType(Material.CYAN_STAINED_GLASS);
            }
        } else {
            p.sendMessage(ChatColor.RED + "You don't have enough money to upgrade.");
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        }
    }
}

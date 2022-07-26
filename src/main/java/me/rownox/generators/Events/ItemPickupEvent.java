package me.rownox.generators.Events;

import me.rownox.generators.Generators;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import static me.rownox.generators.Generators.getEconomy;

public class ItemPickupEvent implements Listener {

    @EventHandler
    public void onPickUp(EntityPickupItemEvent e) {
        if (e.getEntity() instanceof Player p) {

            Inventory inv = p.getInventory();
            int itemCount = e.getItem().getItemStack().getAmount();
            int payment = itemCount * Generators.getInstance().config.getInt("Amount: ");

            if (e.getItem().getItemStack().getType() == Material.SUNFLOWER) {
                getEconomy().depositPlayer(p, payment);
                p.sendMessage(ChatColor.DARK_AQUA + "You received " + ChatColor.AQUA + payment);
                new BukkitRunnable(){
                    public void run(){
                        inv.remove(Material.SUNFLOWER);
                    }
                }.runTaskLater(Generators.getInstance(), 1);
            }

        }
    }
}

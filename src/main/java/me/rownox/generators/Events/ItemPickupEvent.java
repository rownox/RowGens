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

public class ItemPickupEvent implements Listener {

    @EventHandler
    public void onPickUp(EntityPickupItemEvent e) {
        if (e.getEntity() instanceof Player p) {
            Inventory inv = p.getInventory();
            int itemCount = e.getItem().getItemStack().getAmount();
            if (e.getItem().getItemStack().getType() == Material.SUNFLOWER) {
                if (Generators.getInstance().getConfig().getBoolean("Vault: ")) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    Bukkit.dispatchCommand(console, "/eco give " + p + " " + itemCount * Generators.getInstance().config.getInt("Amount: "));
                }
                p.sendMessage(ChatColor.DARK_AQUA + "You collected your coins and received " + ChatColor.AQUA + itemCount * Generators.getInstance().config.getInt("Amount: "));
                new BukkitRunnable(){
                    public void run(){
                        inv.remove(Material.SUNFLOWER);
                    }
                }.runTaskLater(Generators.getInstance(), 1);
            }
        }
    }
}

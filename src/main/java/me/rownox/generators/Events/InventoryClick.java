package me.rownox.generators.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static me.rownox.generators.Utils.Generate.sellGlass;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Upgrade Generator")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            } else if (e.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS)) {
                sellGlass(p, 100);
                p.closeInventory();
            } else if (e.getCurrentItem().getType().equals(Material.CYAN_STAINED_GLASS)) {
                sellGlass(p, 300);
                p.closeInventory();
            } else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS)) {
                sellGlass(p, 500);
                p.closeInventory();
            } else if (e.getCurrentItem().getType().equals(Material.LIME_STAINED_GLASS)) {
                sellGlass(p, 700);
                p.closeInventory();
            } else if (e.getCurrentItem().getType().equals(Material.PURPLE_STAINED_GLASS)) {
                sellGlass(p, 900);
                p.closeInventory();
            }
        }
    }
}

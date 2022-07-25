package me.rownox.generators.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class PlayerInteractEvent implements Listener {
    Class upgrade = Upgrade;
    @EventHandler
    public void onInteract(org.bukkit.event.player.PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            upgrade.openInventory(p);
        }
    }
}

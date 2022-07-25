package me.rownox.generators.Events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class BlockBreakEvent implements Listener {

    @EventHandler
    public void onBreak(org.bukkit.event.block.BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.hasMetadata("PlayerPlaced")) {
            p.getInventory().addItem(new ItemStack(b.getType()));
        }
    }
}
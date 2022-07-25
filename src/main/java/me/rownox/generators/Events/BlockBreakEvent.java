package me.rownox.generators.Events;

import org.bukkit.Location;
import org.bukkit.Material;
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

        Location loc = b.getLocation();
        Location centerOfBlock = loc.add(0.5, 0.5, 0.5);

        if (b.hasMetadata("PlayerPlaced")) {
            b.getWorld().dropItemNaturally(centerOfBlock, new ItemStack(b.getType()));
        }
    }
}
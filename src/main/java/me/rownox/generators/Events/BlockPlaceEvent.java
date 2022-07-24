package me.rownox.generators.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static me.rownox.generators.Utils.Generate.generate;

public class BlockPlaceEvent implements Listener {

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        Material blockMat = e.getBlock().getType();
        int locX = block.getLocation().getBlockX();
        int locY = block.getLocation().getBlockY();
        int locZ = block.getLocation().getBlockZ();

        if (blockMat.equals(Material.WHITE_STAINED_GLASS)) {
            generate(p, 200, locX, locY, locZ);
        } else if (blockMat.equals(Material.CYAN_STAINED_GLASS)) {
            generate(p, 180, locX, locY, locZ);
        } else if (blockMat.equals(Material.RED_STAINED_GLASS)) {
            generate(p, 160, locX, locY, locZ);
        } else if (blockMat.equals(Material.GREEN_STAINED_GLASS)) {
            generate(p, 140, locX, locY, locZ);
        } else if (blockMat.equals(Material.PURPLE_STAINED_GLASS)) {
            generate(p, 120, locX, locY, locZ);
        }
    }
}

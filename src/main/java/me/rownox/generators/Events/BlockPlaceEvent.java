package me.rownox.generators.Events;

import org.bukkit.Location;
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
        Location loc = block.getLocation();

        if (blockMat.equals(Material.WHITE_STAINED_GLASS)) {
            generate(p, 200, loc);
        } else if (blockMat.equals(Material.CYAN_STAINED_GLASS)) {
            generate(p, 180, loc);
        } else if (blockMat.equals(Material.RED_STAINED_GLASS)) {
            generate(p, 160, loc);
        } else if (blockMat.equals(Material.GREEN_STAINED_GLASS)) {
            generate(p, 140, loc);
        } else if (blockMat.equals(Material.PURPLE_STAINED_GLASS)) {
            generate(p, 120, loc);
        }
    }
}

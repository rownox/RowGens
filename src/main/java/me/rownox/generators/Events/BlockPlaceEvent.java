package me.rownox.generators.Events;

import me.rownox.generators.Generators;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

import static me.rownox.generators.Generators.gens;
import static me.rownox.generators.Utils.Generate.generate;

public class BlockPlaceEvent implements Listener {

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {

        Player p = e.getPlayer();
        Block block = e.getBlock();
        Material blockMat = e.getBlock().getType();
        Location loc = block.getLocation();

        if (gens.containsKey(blockMat)) {
            int time = gens.get(blockMat);
            generate(p, time, loc);
        }

        block.setMetadata("PlayerPlaced", new FixedMetadataValue(Generators.getInstance(), true));
    }
}

package me.rownox.generators.Events;

import me.rownox.generators.Generators;
import me.rownox.generators.Utils.Generator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static me.rownox.generators.Generators.generators;
import static me.rownox.generators.Utils.Generate.generate;

public class BlockPlaceEvent implements Listener {

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        Material blockMat = e.getBlock().getType();
        Location loc = block.getLocation();

        for (Generator generator : generators) {
            if (generator.getMat() == blockMat) {
                int time = generator.getTime();
                generate(p, time, loc);
                break;
            }
        }
    }
}

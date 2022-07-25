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

import static me.rownox.generators.Utils.Generate.generate;

public class BlockPlaceEvent implements Listener {

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {

        Player p = e.getPlayer();
        Block block = e.getBlock();
        Material blockMat = e.getBlock().getType();
        Location loc = block.getLocation();

        if (blockMat.equals(Material.WHITE_STAINED_GLASS)) {
            generate(p, 200, loc, ChatColor.WHITE + "" + ChatColor.BOLD + "Tier 1");
        } else if (blockMat.equals(Material.CYAN_STAINED_GLASS)) {
            generate(p, 180, loc, ChatColor.AQUA + "" + ChatColor.BOLD + "Tier 2");
        } else if (blockMat.equals(Material.RED_STAINED_GLASS)) {
            generate(p, 160, loc, ChatColor.RED + "" + ChatColor.BOLD + "Tier 3");
        } else if (blockMat.equals(Material.GREEN_STAINED_GLASS)) {
            generate(p, 140, loc, ChatColor.GREEN + "" + ChatColor.BOLD + "Tier 4");
        } else if (blockMat.equals(Material.PURPLE_STAINED_GLASS)) {
            generate(p, 120, loc, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Tier 5");
        }

        block.setMetadata("PlayerPlaced", new FixedMetadataValue(Generators.getInstance(), true));
    }
}

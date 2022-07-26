package me.rownox.generators.Events;

import me.rownox.generators.Generators;
import me.rownox.generators.Utils.Generator;
import me.rownox.generators.Utils.SoundUtils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
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

        for (Generator generator : Generators.generators) {
            if (generator.getMat() == b.getType()) {
                p.getInventory().addItem(new ItemStack(b.getType()));
                p.sendMessage(ChatColor.RED + "You picked up this generator.");
                SoundUtils.endermanSound(p);
                break;
            }
        }
    }
}
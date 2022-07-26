package me.rownox.generators.Events;

import me.rownox.generators.Generators;
import me.rownox.generators.Utils.Generator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.rownox.generators.Generators.generators;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onInteract(org.bukkit.event.player.PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            for (Generator generator : generators) {
                if (generator.getMat() == b.getType()) {
                    Material mat = b.getType();

                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.DARK_AQUA + "Click to upgrade!");

                    Inventory gui = Bukkit.createInventory(p, 27, "Upgrade Generator");
                    ItemStack upgrade = new ItemStack(mat, 1);
                    ItemMeta upgradeMeta = upgrade.getItemMeta();

                    upgradeMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + generator.getTier());
                    lore.add(ChatColor.DARK_AQUA + "Cost: " + generator.getCost());

                    upgradeMeta.setLore(lore);
                    upgrade.setItemMeta(upgradeMeta);

                    gui.setItem(13, upgrade);
                    p.openInventory(gui);
                    break; // Just to stop looping through the generators.
                }
            }
        }
    }
}

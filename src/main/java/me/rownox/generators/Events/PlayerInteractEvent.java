package me.rownox.generators.Events;

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

import static me.rownox.generators.Generators.gens;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onInteract(org.bukkit.event.player.PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (gens.containsKey(b.getType())) {
                Material mat = b.getType();

                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.DARK_AQUA + "Click to upgrade!");

                Inventory gui = Bukkit.createInventory(p, 27, "Upgrade Generator");
                ItemStack upgrade = new ItemStack(mat, 1);
                ItemMeta upgradeMeta = upgrade.getItemMeta();
                if (mat.equals(Material.WHITE_STAINED_GLASS)) {
                    upgradeMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Tier I");
                    lore.add(ChatColor.DARK_AQUA + "Cost: " + ChatColor.GOLD + "$100");
                } else if (mat.equals(Material.CYAN_STAINED_GLASS)) {
                    upgradeMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Tier II");
                    lore.add(ChatColor.DARK_AQUA + "Cost: " + ChatColor.GOLD + "$300");
                } else if (mat.equals(Material.RED_STAINED_GLASS)) {
                    upgradeMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Tier III");
                    lore.add(ChatColor.DARK_AQUA + "Cost: " + ChatColor.GOLD + "$500");
                } else if (mat.equals(Material.LIME_STAINED_GLASS)) {
                    upgradeMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Tier IV");
                    lore.add(ChatColor.DARK_AQUA + "Cost: " + ChatColor.GOLD + "$700");
                } else if (mat.equals(Material.PURPLE_STAINED_GLASS)) {
                    upgradeMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Tier V");
                    lore.add(ChatColor.DARK_AQUA + "Cost: " + ChatColor.GOLD + "$900");
                }
                upgradeMeta.setLore(lore);
                upgrade.setItemMeta(upgradeMeta);

                gui.setItem(13, upgrade);
                p.openInventory(gui);
            }
        }
    }
}

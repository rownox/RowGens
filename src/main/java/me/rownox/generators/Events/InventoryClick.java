package me.rownox.generators.Events;

import me.rownox.generators.Generators;
import me.rownox.generators.Utils.Generator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Map;

import static me.rownox.generators.Utils.Generate.sellGlass;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Upgrade Generator")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            for (Generator generator : Generators.generators) {
                if (generator.getMat() == e.getCurrentItem().getType()) {
                    sellGlass(p, generator.getCost());
                    p.closeInventory();
                    break;
                }
            }
        }
    }
}

package me.rownox.generators.Utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public final class SoundUtils {
    public static void endermanSound(Player p) {
        playSound(p, Sound.ENTITY_ENDERMAN_TELEPORT);
    }

    public static void playSound(Player p, Sound sound) {
        p.playSound(p.getLocation(), sound, 1, 1);
    }
}

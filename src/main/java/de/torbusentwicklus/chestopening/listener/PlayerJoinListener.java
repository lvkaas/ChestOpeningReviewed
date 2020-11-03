package de.torbusentwicklus.chestopening.listener;

import de.torbusentwicklus.chestopening.api.provider.ChestOpeningProvider;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@AllArgsConstructor
public class PlayerJoinListener implements Listener {

    private final ChestOpeningProvider chestOpeningProvider;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (chestOpeningProvider.isKnown(player)) return;
        chestOpeningProvider.setChests(player, 0);
    }

}

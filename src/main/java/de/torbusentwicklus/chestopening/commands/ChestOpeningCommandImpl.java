package de.torbusentwicklus.chestopening.commands;

import de.torbusentwicklus.chestopening.api.provider.ChestOpeningProvider;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ChestOpeningCommandImpl implements IChestOpeningCommand {

    private final ChestOpeningProvider chestOpeningProvider;

    @Override
    public void listItems(Player player) {

    }

    @Override
    public void addItem(Player player, String whatEver) {

    }

    @Override
    public void addChest(Player player, String whatEver) {

    }

    @Override
    public void removeChest(Player player, String whatEver) {

    }
}

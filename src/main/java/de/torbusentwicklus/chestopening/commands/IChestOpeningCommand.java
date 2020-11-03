package de.torbusentwicklus.chestopening.commands;

import org.bukkit.entity.Player;

public interface IChestOpeningCommand {

    void listItems(Player player);

    void addItem(Player player, String whatEver);

    void addChest(Player player, String whatEver);

    void removeChest(Player player, String whatEver);

}

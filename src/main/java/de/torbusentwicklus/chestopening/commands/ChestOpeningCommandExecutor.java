package de.torbusentwicklus.chestopening.commands;

import lombok.AllArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ChestOpeningCommandExecutor implements CommandExecutor {

    private final IChestOpeningCommand iChestOpeningCommand;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("");
            return false;
        }

        Player player = (Player) commandSender;

        if (args.length == 1 && args[0].equalsIgnoreCase("items")) {
            iChestOpeningCommand.listItems(player);
            return false;
        }

        if (args.length == 3 && args[0].equalsIgnoreCase("items")) {

            if (args[1].equalsIgnoreCase("add")) {
                iChestOpeningCommand.addItem(player, "whatEver");
                return false;
            }

            if (args[1].equalsIgnoreCase("addchest")) {
                iChestOpeningCommand.addChest(player, "whatEver");
                return false;
            }

            if (args[1].equalsIgnoreCase("removechest")) {
                iChestOpeningCommand.removeChest(player, "whatEver");
                return false;
            }

            return false;
        }

        return false;
    }


}

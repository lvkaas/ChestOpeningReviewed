package de.torbusentwicklus.chestopening.api.provider;

import de.torbusentwicklus.chestopening.api.mysql.MySqlConnection;
import de.torbusentwicklus.chestopening.api.spigot.ItemBuilder;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ChestOpeningProvider {

    private final List<ItemStack> itemStacks = new ArrayList<>();
    private final Map<Integer, Integer> rarities = new HashMap<>();

    private final MySqlConnection mySqlConnection;

    @PostConstruct
    private void boot() {
        try {
            mySqlConnection.connect();
            loadRaritiesFromSql();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void loadRaritiesFromSql() throws SQLException {
        ResultSet resultSet = mySqlConnection.getConnection().prepareStatement("SELECT * FROM items").executeQuery();
        while (resultSet.next()) {
            ItemStack item = new ItemBuilder().fromBase64(resultSet.getString("BASE64")).build();
            for (int i = 0; i < rarities.get(resultSet.getInt("RARITY")); i++) {
                itemStacks.add(item);
            }
        }
    }

    public void openChestOpeningChest(Player player, Player chestLocation) {
        //YOUR CHEST OPENING MAGIC
    }

    public boolean isKnown(Player player) {
        //YOUR isKnown MAGIC
        return true;
    }

    public void setChests(Player player, int someInt) {
        //YOUR setChests MAGIC
    }

}

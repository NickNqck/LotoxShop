package fr.nicknqck.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    private final File file;
    private final FileConfiguration config;

    public PlayerDataManager(JavaPlugin plugin) {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        this.file = new File(dataFolder, "players.yml");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void saveData(Map<UUID, PlayerData> playerDataMap) {
        for (Map.Entry<UUID, PlayerData> entry : playerDataMap.entrySet()) {
            UUID uuid = entry.getKey();
            PlayerData playerData = entry.getValue();
            config.set(uuid.toString() + ".name", playerData.getName());
            config.set(uuid + ".isOp", playerData.isOp());
            config.set(uuid + ".shopAmount", playerData.getCoins());
            config.set(uuid + ".achatAmount", playerData.getAmountPurchase());
            config.set(uuid + ".rank", playerData.getRank().getName());
        }
        try {
            config.save(file);
        } catch (IOException e) {
            System.err.println("Unable to save configuration file");
            e.printStackTrace();
        }
    }
    public void loadData(Map<UUID, PlayerData> playerDataMap) {
        for (String key : config.getKeys(false)) {
            UUID uuid = UUID.fromString(key);
            String name = config.getString(key + ".name");
            boolean isOp = config.getBoolean(key + ".isOp");
            int shopAmount = config.getInt(key + ".shopAmount");
            int achatAmount = config.getInt(key+ ".achatAmount");
            Ranks rank = Ranks.getFromString(config.getString(key+".rank"));
            playerDataMap.put(uuid, new PlayerData(name, isOp, shopAmount, achatAmount, rank));
        }
    }
}
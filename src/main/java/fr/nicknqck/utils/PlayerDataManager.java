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
            dataFolder.mkdirs(); // Assurez-vous que le dossier de données existe
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

    public void saveData(Map<UUID, Integer> shopContainer) {
        for (Map.Entry<UUID, Integer> entry : shopContainer.entrySet()) {
            config.set(entry.getKey().toString(), entry.getValue());
        }
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData(Map<UUID, Integer> shopContainer) {
        for (String key : config.getKeys(false)) {
            UUID uuid = UUID.fromString(key);
            int value = config.getInt(key);
            shopContainer.put(uuid, value);
        }
    }
}

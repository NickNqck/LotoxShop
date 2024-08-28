package fr.nicknqck.utils;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
            Map<String, Location> homes = playerData.getHomes();
            Map<String, Map<String, Object>> serializedHomes = new HashMap<>();
            for (Map.Entry<String, Location> homeEntry : homes.entrySet()) {
                String homeName = homeEntry.getKey();
                Location location = homeEntry.getValue();
                serializedHomes.put(homeName, location.serialize());
            }
            config.set(uuid + ".homes", serializedHomes);
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
            int achatAmount = config.getInt(key + ".achatAmount");
            Ranks rank = Ranks.getFromString(config.getString(key + ".rank"));

            // Chargement des homes
            Map<String, Location> homes = loadHomes(uuid);

            // Création du PlayerData avec les homes
            PlayerData playerData = new PlayerData(name, isOp, shopAmount, achatAmount, rank, homes);
            playerDataMap.put(uuid, playerData);
        }
    }
    public Map<String, Location> loadHomes(UUID playerUUID) {
        Map<String, Location> homes = new HashMap<>();

        // Récupérer la section des homes pour ce joueur
        ConfigurationSection homesSection = config.getConfigurationSection(playerUUID.toString() + ".homes");
        if (homesSection != null) {
            for (String homeName : homesSection.getKeys(false)) {
                // Récupérer la map sérialisée de chaque location
                Map<String, Object> serializedLocation = homesSection.getConfigurationSection(homeName).getValues(false);

                // Désérialiser la location
                Location location = Location.deserialize(serializedLocation);

                // Ajouter à la map des homes
                homes.put(homeName, location);
            }
        }

        return homes;
    }
    @SuppressWarnings("unchecked")
    public Location[] loadLocationsFromConfig(String path, FileConfiguration config) {
        List<Map<?, ?>> serializedLocations = config.getMapList(path);
        Location[] locations = new Location[serializedLocations.size()];

        for (int i = 0; i < serializedLocations.size(); i++) {
            Map<String, Object> locMap = (Map<String, Object>) serializedLocations.get(i);
            locations[i] = Location.deserialize(locMap);
        }
        return locations;
    }

}
package fr.nicknqck.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    private final File file;
    private final File potions;
    private final FileConfiguration config;
    private final FileConfiguration potionsConfig;

    public PlayerDataManager(JavaPlugin plugin) {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        this.potions = new File(dataFolder, "potions.yml");
        this.file = new File(dataFolder, "players.yml");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!potions.exists()){
                potions.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.config = YamlConfiguration.loadConfiguration(file);
        this.potionsConfig = YamlConfiguration.loadConfiguration(potions);
    }

    public void saveData(Map<UUID, PlayerData> playerDataMap) {
        for (Map.Entry<UUID, PlayerData> entry : playerDataMap.entrySet()) {
            UUID uuid = entry.getKey();
            PlayerData playerData = entry.getValue();
            config.set(uuid.toString() + ".name", playerData.getName());
            config.set(uuid + ".isOp", playerData.isOp());
            config.set(uuid + ".shopAmount", playerData.getCoins());
            config.set(uuid + ".achatAmount", playerData.getAmountPurchase());
        }
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        savePotionsData(playerDataMap);
    }
    public void savePotionsData(Map<UUID, PlayerData> playerDataMap) {
        for (Map.Entry<UUID, PlayerData> entry : playerDataMap.entrySet()){
            UUID uuid = entry.getKey();
            PlayerData playerData = entry.getValue();
            potionsConfig.set(uuid.toString() +".name", playerData.getName());
            potionsConfig.set(uuid + ".achatPotionAmount", playerData.getAmountPotionPurchase());
            potionsConfig.set(uuid + ".effects", playerData.getEffects());
        }
        try {
            potionsConfig.save(potions);
        } catch (IOException e) {
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
            int achatPotionAmount = potionsConfig.getInt(key+ ".achatPotionAmount");
            List<String> a = potionsConfig.getComments(key + ".effects");
            List<PotionEffectType> effects = new ArrayList<>();
            for (String string : a){
                if (PotionEffectType.getByName(string) != null){
                    effects.add(PotionEffectType.getByName(string));
                }
            }
            playerDataMap.put(uuid, new PlayerData(name, isOp, shopAmount, achatAmount, achatPotionAmount, effects));
        }
    }
}
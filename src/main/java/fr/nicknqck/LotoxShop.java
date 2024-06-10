package fr.nicknqck;

import fr.nicknqck.utils.Inventories;
import fr.nicknqck.utils.PlayerData;
import fr.nicknqck.utils.PlayerDataManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class LotoxShop extends JavaPlugin {

    @Getter
    private static LotoxShop instance;
    @Getter
    private PlayerDataManager playerDataManager;
    @Getter
    private Inventories inventories;
    @Getter
    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();
    @Override
    public void onEnable() {
        instance = this;
        this.playerDataManager = new PlayerDataManager(this);
        inventories = new Inventories();
        this.playerDataManager.loadData(playerDataMap);
        registerCommands();
    }
    @Override
    public void onDisable() {
        getPlayerDataManager().saveData(playerDataMap);
    }
    private void registerCommands(){
        Objects.requireNonNull(getServer().getPluginCommand("market")).setExecutor(new MarketCommand());
    }
    public void addCoins(UUID uuid, int coins){
        if (playerDataMap.containsKey(uuid)){
            setCoins(uuid, playerDataMap.get(uuid).getCoins()+coins);
        } else {
            setCoins(uuid, coins);
        }
    }
    public void setCoins(UUID uuid, int coins){
        if (!playerDataMap.containsKey(uuid)){
            playerDataMap.put(uuid, new PlayerData(Objects.requireNonNull(Bukkit.getPlayer(uuid)).getName(), Objects.requireNonNull(Bukkit.getPlayer(uuid)).isOp(), 0));
        }
        playerDataMap.get(uuid).setCoins(coins);
        getPlayerDataManager().saveData(playerDataMap);
    }
}

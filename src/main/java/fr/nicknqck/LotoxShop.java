package fr.nicknqck;

import fr.nicknqck.utils.PlayerDataManager;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class LotoxShop extends JavaPlugin {

    @Getter
    private static LotoxShop instance;
    @Getter
    private static final Map<UUID, Integer> shopContainer = new HashMap<>();
    @Getter
    private PlayerDataManager playerDataManager;
    @Override
    public void onEnable() {
        instance = this;
        this.playerDataManager = new PlayerDataManager(this);
        this.playerDataManager.loadData(shopContainer);
        registerCommands();
        getPlayerDataManager().loadData(shopContainer);
    }
    @Override
    public void onDisable() {
        getPlayerDataManager().saveData(getShopContainer());
    }
    private void registerCommands(){
        Objects.requireNonNull(getServer().getPluginCommand("market")).setExecutor(new MarketCommand());
    }
    public int addCoins(UUID uuid, int coins){
        if (shopContainer.containsKey(uuid)){
            int aAmount = shopContainer.get(uuid);
            shopContainer.remove(uuid, aAmount);
            shopContainer.put(uuid, aAmount+coins);
            getPlayerDataManager().saveData(shopContainer);
            return aAmount+coins;
        } else {
            shopContainer.put(uuid, coins);
            getPlayerDataManager().saveData(shopContainer);
            return coins;
        }
    }
}

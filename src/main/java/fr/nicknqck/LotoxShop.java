package fr.nicknqck;

import fr.mrmicky.fastboard.FastBoard;
import fr.nicknqck.utils.*;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
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
    private PlayerDataManager playerDataManager;
    @Getter
    private Inventories inventories;
    @Getter
    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();
    @Getter
    private final Map<UUID, FastBoard> boards = new HashMap<>();
    @Override
    public void onEnable() {
        instance = this;
        this.playerDataManager = new PlayerDataManager(this);
        inventories = new Inventories();
        this.playerDataManager.loadData(playerDataMap);
        registerCommands();
        registerListeners();
        for (Player p : Bukkit.getOnlinePlayers()){
            PlayerListeners.onBoardJoin(p);
        }
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
    }
    @Override
    public void onDisable() {
        getPlayerDataManager().saveData(playerDataMap);
    }
    private void registerCommands(){
        Objects.requireNonNull(getServer().getPluginCommand("market")).setExecutor(new MarketCommand());
    }
    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
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
    private void    updateBoard(FastBoard board) {
        board.updateLines(
                "",
                "§a§l • Infos Joueur ",
                "",
                "Pseudo: "+board.getPlayer().getName(),
                "Temp de jeu: "+ StringUtils.secondsTowardsBeautifulinScoreboard(board.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE)/20),
                "Coins: " + getPlayerDataMap().get(board.getPlayer().getUniqueId()).getCoins(),
                "",
                "Kills: "+board.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                "Morts: "+board.getPlayer().getStatistic(Statistic.DEATHS)
        );
    }
}

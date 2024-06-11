package fr.nicknqck;

import fr.mrmicky.fastboard.FastBoard;
import fr.nicknqck.listeners.BuyMarket;
import fr.nicknqck.listeners.PlayerListeners;
import fr.nicknqck.listeners.SellMarket;
import fr.nicknqck.utils.*;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
        getServer().getPluginManager().registerEvents(new SellMarket(), this);
        getServer().getPluginManager().registerEvents(new BuyMarket(), this);
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
    private void updateBoard(FastBoard board) {
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
    public int getItemAmount(Player player, Material material) {
        //Methode is from UHC_MEETUP, owner by NickNqck
        int toReturn = 0;
        for (ItemStack content : player.getInventory().getContents()) {
            if (content != null && content.getType() == material) {
                toReturn += content.getAmount();
            }
        }
        return toReturn;
    }
    public void removeItem(Player player, Material material, int remove) {
        //Methode is from UHC_MEETUP, owned by NickNqck
        if (Objects.requireNonNull(player.getInventory().getItem(player.getInventory().first(material))).getAmount() <= remove) {
            player.getInventory().removeItem(player.getInventory().getItem(player.getInventory().first(material)));
            return;
        }
        Objects.requireNonNull(player.getInventory().getItem(player.getInventory().first(material))).setAmount(Objects.requireNonNull(player.getInventory().getItem(player.getInventory().first(material))).getAmount() - remove);
        if (remove > 64) {
            Objects.requireNonNull(player.getInventory().getItem(player.getInventory().first(material))).setAmount(Objects.requireNonNull(player.getInventory().getItem(player.getInventory().first(material))).getAmount() - (remove - 64));
        }
    }
}

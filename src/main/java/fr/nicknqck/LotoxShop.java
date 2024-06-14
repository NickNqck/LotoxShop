package fr.nicknqck;

import fr.mrmicky.fastboard.FastBoard;
import fr.nicknqck.listeners.PlayerListeners;
import fr.nicknqck.listeners.SellMarket;
import fr.nicknqck.listeners.buy.BuyMarket;
import fr.nicknqck.listeners.buy.benediction.BenedictionMarket;
import fr.nicknqck.listeners.buy.blocs.BlocsMarket;
import fr.nicknqck.listeners.buy.conssumable.ConssomableMarket;
import fr.nicknqck.listeners.buy.food.FoodMarket;
import fr.nicknqck.listeners.buy.equipement.EquipementMarket;
import fr.nicknqck.listeners.customevents.onSecondEvent;
import fr.nicknqck.utils.*;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

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
    public static Random RANDOM = new Random();
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
            getInventories().openBootsBuyMarketInventory(p);
            getInventories().openSwordsBuyMarketInventory(p);
        }
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
                Bukkit.getPluginManager().callEvent(new onSecondEvent());
            }
        }, 0, 20);
    }
    @Override
    public void onDisable() {
        getPlayerDataManager().saveData(playerDataMap);
    }
    private void registerCommands(){
        Objects.requireNonNull(getServer().getPluginCommand("market")).setExecutor(new MarketCommand());
        Objects.requireNonNull(getServer().getPluginCommand("pay")).setExecutor(new PayCommand());
        Objects.requireNonNull(getServer().getPluginCommand("furnace")).setExecutor(new FurnaceCommand());
        Objects.requireNonNull(getServer().getPluginCommand("tpa")).setExecutor(new TpaCommand());
    }
    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new SellMarket(), this);
        getServer().getPluginManager().registerEvents(new BuyMarket(), this);
        getServer().getPluginManager().registerEvents(new EquipementMarket(), this);
        getServer().getPluginManager().registerEvents(new ConssomableMarket(), this);
        getServer().getPluginManager().registerEvents(new BlocsMarket(), this);
        getServer().getPluginManager().registerEvents(new FoodMarket(), this);
        getServer().getPluginManager().registerEvents(new BenedictionMarket(), this);
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
            playerDataMap.put(uuid, new PlayerData(Objects.requireNonNull(Bukkit.getPlayer(uuid)).getName(), Objects.requireNonNull(Bukkit.getPlayer(uuid)).isOp(), 0, 0));
        }
        playerDataMap.get(uuid).setCoins(coins);
        getPlayerDataManager().saveData(playerDataMap);
    }
    private void updateBoard(FastBoard board) {
        board.updateLines(
                "",
                "§l • §7§lPROFIL ",
                "",
                "§7§l・§bCompte: §e" + board.getPlayer().getName(),
                "§7§l・§bCoins: §a§l" + getPlayerDataMap().get(board.getPlayer().getUniqueId()).getCoins() + "§e 💰",
                "§7§l・§bEffets: §rAucun",
                "",
                "§l • §7§lSTATISTIQUES ",
                "",
                "§7§l・§aKills: " + board.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                "§7§l・§cMorts: " + board.getPlayer().getStatistic(Statistic.DEATHS),
                "§7§l・§9Joueurs: §b" + Bukkit.getOnlinePlayers().size(),
                "§7§l・§9Temps de jeu: §e" + StringUtils.secondsTowardsBeautifulinScoreboard(board.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE)/20)
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
    public void giveItem(Player target, Material material, int amount) {
            if (countEmptySlots(target) > 0) {
                target.getInventory().addItem(new ItemBuilder(material).setAmount(amount).toItemStack());
            }else {
                if (target.getInventory().contains(new ItemStack(material))) {
                    for (ItemStack s : target.getInventory().getContents()) {
                        if (s == null)return;
                        if (s.getType() != material)return;
                            if (s.getAmount() + amount <= 64) {
                                target.getInventory().addItem(new ItemBuilder(material).setAmount(amount).toItemStack());
                            } else {
                                target.getWorld().dropItemNaturally(target.getLocation(), new ItemBuilder(material).setAmount(amount).toItemStack());
                            }
                    }
                }
            }
    }
    public void giveItem(Player target, ItemStack... items) {
        for (ItemStack item : items){
            if (countEmptySlots(target) > 0) {
                target.getInventory().addItem(item);
            }else {
                target.getWorld().dropItemNaturally(target.getLocation(), item);
            }
        }
    }
    private int countEmptySlots(Player player) {
        int emptySlots = 0;
        ItemStack[] contents = player.getInventory().getContents();
        for (ItemStack item : contents) {
            if (item == null || item.getType() == Material.AIR) {
                emptySlots++;
            }
        }
        return emptySlots;
    }
    public String getStringCoins(UUID uuid){
        return formatCoins(getPlayerDataMap().get(uuid).getCoins());
    }
    public String getStringCoins(int montant){
        return formatCoins(montant);
    }
    private String formatCoins(int coins) {
        if (coins >= 1_000_000) {
            return String.format("%.1fM", coins / 1_000_000.0);
        } else if (coins >= 1_000) {
            return String.format("%.1fk", coins / 1_000.0);
        } else {
            return String.valueOf(coins);
        }
    }
    private int getPriceFromLore(List<String> lore) {
        for (String line : lore) {
            if (line.contains("Prix: ")) {
                String priceString = line.replaceAll("\\D", "");
                System.out.println("1 "+priceString);
                priceString = priceString.substring(1);
                System.out.println("2 "+priceString);
                return Integer.parseInt(priceString);
            }
        }
        return 0;
    }
    public boolean buyItem(Player player, ItemStack item, boolean give) {
        addCoins(player.getUniqueId(), 0);
        int price = getPriceFromLore(Objects.requireNonNull(Objects.requireNonNull(item.getItemMeta()).getLore()));
        System.out.println("price: "+price);
        if (getPlayerDataMap().get(player.getUniqueId()).getCoins() >= price) {
            if (give){
                giveItem(player, item);
            }
            getPlayerDataMap().get(player.getUniqueId()).setAmountPurchase(getPlayerDataMap().get(player.getUniqueId()).getAmountPurchase()+1);
            addCoins(player.getUniqueId(), -price);
            return true;
        }
        return false;
    }
    public void tryBuying(Player player, ItemStack item){
        if (item.hasItemMeta() && Objects.requireNonNull(item.getItemMeta()).hasLore()){
            if (LotoxShop.getInstance().buyItem(player, item, true)) {
                player.sendMessage("§aVous avez acheter l'item: \""+(item.getItemMeta().hasDisplayName() ? item.getItemMeta().getDisplayName() : item.getType().name())+"§a\"");
            } else {
                player.sendMessage("§cVous n'avez pas asser pour acheter cette objet !");
            }
        }
    }
    public int getPotionEffectLevel(Player player, PotionEffectType type) {
        // Vérifier si le joueur a l'effet de potion
        if (player.hasPotionEffect(type)) {
            // Obtenir l'effet de potion
            PotionEffect effect = player.getPotionEffect(type);
            if (effect != null) {
                // Retourner le niveau de l'effet + 1 car le niveau commence à 0 pour le niveau 1
                return effect.getAmplifier();
            }
        }
        // Retourner 0 si le joueur n'a pas l'effet de potion
        return 0;
    }

}

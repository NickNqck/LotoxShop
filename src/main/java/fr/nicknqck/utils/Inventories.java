package fr.nicknqck.utils;

import fr.nicknqck.LotoxShop;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@Getter
public class Inventories {
    private final ItemStack SellMarket =  new ItemBuilder(Material.GREEN_DYE).setName("§r§aVendre").toItemStack();
    private final ItemStack ReturnArrow = new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack();
    private final ItemStack BuyMarket = new ItemBuilder(Material.RED_DYE).setName("§r§cAcheter").setAmount(1).toItemStack();
    public void openIronSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lFer§7 -§6 "+ LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i+=6){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.IRON_INGOT).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_INGOT).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.IRON_INGOT).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }
    public void openGoldSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lOr§7 -§6 "+LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i+=6){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.GOLD_INGOT).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.GOLD_INGOT).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.GOLD_INGOT).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }
    public void openDiamondSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lDiamant§7 -§6 "+LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i+=6){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.DIAMOND).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.DIAMOND).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }
    public void openEmeraldSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lÉmeraude§7 -§6 "+LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i+=6){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.EMERALD).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.EMERALD).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.EMERALD).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }
    public void openSellMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§a§n§lVendre§7 -§6 "+LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 36; i <= 45; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 17; i+=8){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 27; i <= 35; i+=8){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(36, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        inv.setItem(19, new ItemBuilder(Material.IRON_INGOT).setName("§r§fFer").toItemStack());
        inv.setItem(21, new ItemBuilder(Material.GOLD_INGOT).setName("§r§6Or").toItemStack());
        inv.setItem(23, new ItemBuilder(Material.DIAMOND).setName("§r§bDiamant").toItemStack());
        inv.setItem(25, new ItemBuilder(Material.EMERALD).setName("§r§aÉmeraude").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }
    public void openBasicMarketInventory(Player player){
        if (!LotoxShop.getInstance().getPlayerDataMap().containsKey(player.getUniqueId())){
            LotoxShop.getInstance().setCoins(player.getUniqueId(), 0);
        }
        Inventory inv = Bukkit.createInventory(player, 9*5, "§6§n§lMarket§r§7 -§6 "+LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 36; i <= 45; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 17; i+=8){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 27; i <= 35; i+=8){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(21, SellMarket);
        inv.setItem(23, BuyMarket);
        player.openInventory(inv);
    }
    public void openBuyMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§c§n§lAcheter§7 -§6 "+LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 36; i <= 45; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 17; i+=8){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 27; i <= 35; i+=8){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(36, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        inv.setItem(19, new ItemBuilder(Material.IRON_INGOT).setName("§r§fFer").toItemStack());
        inv.setItem(21, new ItemBuilder(Material.GOLD_INGOT).setName("§r§6Or").toItemStack());
        inv.setItem(23, new ItemBuilder(Material.DIAMOND).setName("§r§bDiamant").toItemStack());
        inv.setItem(25, new ItemBuilder(Material.EMERALD).setName("§r§aÉmeraude").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }
    public void openIronBuyInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§c§n§lFer§7 -§6 "+ LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins()+" coins");
        for (int i = 0; i <= 9; i+=7){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i+1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        //2
        for (int i = 9; i <= 18; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i+=6){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i+=9){
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.IRON_INGOT).setName("§a+1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_INGOT).setName("§a+16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.IRON_INGOT).setName("§a+32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }
}
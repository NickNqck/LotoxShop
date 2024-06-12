package fr.nicknqck.utils;

import fr.nicknqck.LotoxShop;
import fr.nicknqck.listeners.buy.potion.SellablePotions;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@Getter
public class Inventories {
    private final ItemStack SellMarket =  new ItemBuilder(Material.GREEN_DYE).setName("§r§aVendre").toItemStack();
    private final ItemStack ReturnArrow = new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack();
    private final ItemStack BuyMarket = new ItemBuilder(Material.RED_DYE).setName("§r§cAcheter").setAmount(1).toItemStack();
    public void openIronSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lFer§7 -§6 "+ LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lOr§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lDiamant§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lÉmeraude§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        Inventory inv = Bukkit.createInventory(player, 9*5, "§a§n§lVendre§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        inv.setItem(25, new ItemBuilder(Material.DIAMOND).setName("§r§bDiamant").toItemStack());
        inv.setItem(23, new ItemBuilder(Material.EMERALD).setName("§r§aÉmeraude").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }
    public void openBasicMarketInventory(Player player){
        if (!LotoxShop.getInstance().getPlayerDataMap().containsKey(player.getUniqueId())){
            LotoxShop.getInstance().setCoins(player.getUniqueId(), 0);
        }
        Inventory inv = Bukkit.createInventory(player, 9*5, "§6§n§lMarket§r§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        Inventory inv = Bukkit.createInventory(player, 9*5, "§c§n§lAcheter§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        inv.setItem(11, new ItemBuilder(Material.BOOK).setName("§r§fKits").setLore("Pas encore développer...").toItemStack());
        inv.setItem(13, new ItemBuilder(Material.ARMOR_STAND).setName("§r§fÉquipement").toItemStack());
        inv.setItem(15, new ItemBuilder(Material.COOKED_BEEF).setName("§r§fNourriture").setLore("Pas encore développer...").toItemStack());
        inv.setItem(29, new ItemBuilder(Material.POTION).hideAttributes(ItemFlag.HIDE_POTION_EFFECTS).setName("§r§fEffets").setPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*60*8, 0, false, false)).toItemStack());
        inv.setItem(31, new ItemBuilder(Material.BRICKS).setName("§r§fBlocs").setLore("Pas encore développer...").toItemStack());
        inv.setItem(33, new ItemBuilder(Material.ARROW).setName("§r§fConssumable").setLore("Pas encore développer...").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }
    public void openEquipementMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§c§n§lÉquipement§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        inv.setItem(11, new ItemBuilder(Material.NETHERITE_SWORD).setName("§r§fÉpées").toItemStack());
        inv.setItem(13, new ItemBuilder(Material.NETHERITE_HELMET).setName("§r§fCasques").toItemStack());
        inv.setItem(15, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("Plaston").toItemStack());
        inv.setItem(29, new ItemBuilder(Material.BOW).setName("Arcs").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openSwordsBuyMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§c§n§lÉpées§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        inv.setItem(11, new ItemBuilder(Material.IRON_SWORD).setName("§c§lSword of Kratos").setLore("","§6Prix: "+6500+" coins")
                .addEnchant(Enchantment.DAMAGE_ALL, 4)
                .addEnchant(Enchantment.FIRE_ASPECT, 3)
                .addEnchant(Enchantment.DURABILITY, 2)
                .toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }
    public void openHelmetsBuyMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§c§n§lCasques§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        inv.setItem(11, new ItemBuilder(Material.IRON_HELMET).setName("§c§lCasque d'elfe").setLore("","§6Prix: "+7500+" coins")
                .addEnchant(Enchantment.PROTECTION_PROJECTILE, 5)
                .addEnchant(Enchantment.OXYGEN, 3)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.MENDING,1)
                .toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }public void openChestPlateBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lPlastrons§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        for (int i = 0; i <= 9; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 36; i <= 45; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 17; i += 8) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 27; i <= 35; i += 8) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(36, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        inv.setItem(11, new ItemBuilder(Material.IRON_CHESTPLATE).setName("§c§lPlastron d'elfe").setLore("", "§6Prix: " + 10000 + " coins")
                .addEnchant(Enchantment.PROTECTION_PROJECTILE, 5)
                .addEnchant(Enchantment.MENDING, 1)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }public void openBowBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lArc§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        for (int i = 0; i <= 9; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 36; i <= 45; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 17; i += 8) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 27; i <= 35; i += 8) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(36, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        inv.setItem(11, new ItemBuilder(Material.BOW).setName("§c§lArc d'Elfe").setLore("", "§6Prix: " + 30000 + " coins")
                .addEnchant(Enchantment.ARROW_DAMAGE, 7)
                .addEnchant(Enchantment.MENDING, 1)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.ARROW_FIRE, 1)
                .addEnchant(Enchantment.ARROW_INFINITE, 1)
                .toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }
    public void openEffetMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§c§n§lEffets§7 -§6 "+LotoxShop.getInstance().getStringCoins(player.getUniqueId())+" coins");
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
        for (SellablePotions potions : SellablePotions.values()){
            inv.setItem(potions.getSlot(), new ItemBuilder(Material.POTION)
                    .setName(potions.getName())
                    .setLore("","§6Prix: "+potions.getOriginalPrice())
                    .setPotionEffect(new PotionEffect(potions.getEffectType(), Integer.MAX_VALUE, LotoxShop.getInstance().getPotionEffectLevel(player, potions.getEffectType()), false, false))
                    .toItemStack());
        }
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

}
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

import java.util.Objects;

@Getter
public class Inventories {
    private final ItemStack SellMarket = new ItemBuilder(Material.GREEN_DYE).setName("§r§aVendre").toItemStack();
    private final ItemStack ReturnArrow = new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack();
    private final ItemStack BuyMarket = new ItemBuilder(Material.RED_DYE).setName("§r§cAcheter").setAmount(1).toItemStack();

    public void openIronSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 3, "§a§n§lFer§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        for (int i = 0; i <= 9; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i += 6) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.IRON_INGOT).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_INGOT).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.IRON_INGOT).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }

    public void openGoldSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 3, "§a§n§lOr§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        for (int i = 0; i <= 9; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i += 6) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.GOLD_INGOT).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.GOLD_INGOT).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.GOLD_INGOT).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }

    public void openDiamondSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 3, "§a§n§lDiamant§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        for (int i = 0; i <= 9; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i += 6) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.DIAMOND).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.DIAMOND).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }

    public void openEmeraldSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 3, "§a§n§lÉmeraude§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        for (int i = 0; i <= 9; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i += 6) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.EMERALD).setName("§c-1").setAmount(1).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.EMERALD).setName("§c-16").setAmount(16).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.EMERALD).setName("§c-32").setAmount(32).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }

    public void openSellMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§a§n§lVendre§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(19, new ItemBuilder(Material.IRON_INGOT).setName("§r§fFer").toItemStack());
        inv.setItem(21, new ItemBuilder(Material.GOLD_INGOT).setName("§r§6Or").toItemStack());
        inv.setItem(25, new ItemBuilder(Material.DIAMOND).setName("§r§bDiamant").toItemStack());
        inv.setItem(23, new ItemBuilder(Material.EMERALD).setName("§r§aÉmeraude").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openBasicMarketInventory(Player player) {
        if (!LotoxShop.getInstance().getPlayerDataMap().containsKey(player.getUniqueId())) {
            LotoxShop.getInstance().setCoins(player.getUniqueId(), 0);
        }
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§6§n§lMarket§r§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(21, SellMarket);
        inv.setItem(23, BuyMarket);
        player.openInventory(inv);
    }

    public void openBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lAcheter§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.BOOK).setName("§r§fKits").setLore("Pas encore développer...").toItemStack());
        inv.setItem(13, new ItemBuilder(Material.ARMOR_STAND).setName("§r§fÉquipement").toItemStack());
        inv.setItem(15, new ItemBuilder(Material.COOKED_BEEF).setName("§r§fNourriture").toItemStack());
        inv.setItem(29, new ItemBuilder(Material.POTION).setLore("Pas encore développer...").hideAttributes(ItemFlag.HIDE_POTION_EFFECTS).setName("§r§fEffets").setPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 60 * 8, 0, false, false)).toItemStack());
        inv.setItem(31, new ItemBuilder(Material.BRICKS).setName("§r§fBlocs").toItemStack());

        inv.setItem(33, new ItemBuilder(Material.ARROW).setName("§r§fConssumable").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openEquipementMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lÉquipement§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.NETHERITE_SWORD).setName("§r§fÉpées").toItemStack());
        inv.setItem(13, new ItemBuilder(Material.NETHERITE_HELMET).setName("§r§fCasques").toItemStack());
        inv.setItem(15, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§r§fPlastrons").toItemStack());
        inv.setItem(31, new ItemBuilder(Material.NETHERITE_LEGGINGS).setName("§r§fJambières").toItemStack());
        inv.setItem(29, new ItemBuilder(Material.BOW).setName("§r§fArcs").toItemStack());
        inv.setItem(21, new ItemBuilder(Material.NETHERITE_AXE).setName("§r§fHaches").toItemStack());
        inv.setItem(23, new ItemBuilder(Material.NETHERITE_SHOVEL).setName("§r§fPelles").toItemStack());
        inv.setItem(25, new ItemBuilder(Material.FISHING_ROD).setName("§r§fRods").toItemStack());
        inv.setItem(33, new ItemBuilder(Material.NETHERITE_BOOTS).setName("§r§fBottes").toItemStack());
        inv.setItem(19, new ItemBuilder(Material.NETHERITE_PICKAXE).setName("§r§fPioches").toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openSwordsBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lÉpées§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.DIAMOND_SWORD).setName("§c§lSword of Kratos").setPrice(6000)
                .addEnchant(Enchantment.DAMAGE_ALL, 4)
                .addEnchant(Enchantment.FIRE_ASPECT, 3)
                .addEnchant(Enchantment.DURABILITY, 2)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.WOODEN_SWORD).setName("§c§lSword of apprentice").setPrice(500)
                .addEnchant(Enchantment.DAMAGE_ALL, 3)
                .addEnchant(Enchantment.DURABILITY, 2)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.IRON_SWORD).setName("§c§Aamateur sword").setPrice(2500)
                .addEnchant(Enchantment.DAMAGE_ALL, 4)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                .toItemStack());
        inv.setItem(21, new ItemBuilder(Material.DIAMOND_SWORD).setName("§c§lExperienced Sword").setPrice(7500)
                .addEnchant(Enchantment.DAMAGE_ALL, 4)
                .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                .addEnchant(Enchantment.DURABILITY, 2)
                .addEnchant(Enchantment.LOOT_BONUS_MOBS, 2)
                .toItemStack());
        inv.setItem(23, new ItemBuilder(Material.IRON_SWORD).setName("§c§lSword of Zeus").setPrice(15000)
                .addEnchant(Enchantment.DAMAGE_ALL, 3)
                .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.LOOT_BONUS_MOBS, 3)
                .setOnDamage(event -> {
                    if (event.getDamager() instanceof Player) {
                        ItemStack item = ((Player) event.getDamager()).getInventory().getItemInMainHand();
                        if (item.hasItemMeta() && Objects.requireNonNull(item.getItemMeta()).hasDisplayName()) {
                            if (item.getItemMeta().getDisplayName().equals("§c§lSword of Zeus")) {
                                if (RandomUtils.getOwnRandomProbability(15)) {
                                    event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
                                }
                            }
                        }
                    }
                })
                .toItemStack());
        inv.setItem(25, new ItemBuilder(Material.DIAMOND_SWORD).setName("§c§lSword of Hades").setPrice(10000)
                .addEnchant(Enchantment.DAMAGE_ALL, 3)
                .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.LOOT_BONUS_MOBS, 3)
                .setOnSeconde(onSecondEvent -> {
                    for (Player player1 : Bukkit.getOnlinePlayers()) {
                        ItemStack item = player1.getInventory().getItemInMainHand();
                        if (item.hasItemMeta()) {
                            if (Objects.requireNonNull(item.getItemMeta()).hasDisplayName()) {
                                if (item.getItemMeta().getDisplayName().equals("§c§lSword of Hades")) {
                                    player1.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 60, 0, false, false));
                                }
                            }
                        }
                    }
                }).toItemStack());

        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openHelmetsBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lCasques§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.IRON_HELMET).setName("§c§lCasque d'elfe").setLore("", "§6Prix: " + 2500 + " coins")
                .addEnchant(Enchantment.PROTECTION_PROJECTILE, 5)
                .addEnchant(Enchantment.OXYGEN, 3)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.GOLDEN_HELMET).setName("§eCasque §ed'Hermes").addEnchant(Enchantment.DURABILITY, 5).setPrice(5000).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openChestPlateBuyMarketInventory(Player player) {
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
        inv.setItem(11, new ItemBuilder(Material.IRON_CHESTPLATE).setName("§c§lPlastron d'elfe").setLore("", "§6Prix: " + 7500 + " coins")
                .addEnchant(Enchantment.PROTECTION_PROJECTILE, 5)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.GOLDEN_CHESTPLATE).setName("§ePlastron §ed'Hermes").addEnchant(Enchantment.DURABILITY, 5).setPrice(5000).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openBowBuyMarketInventory(Player player) {
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
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.ARROW_FIRE, 1)
                .addEnchant(Enchantment.ARROW_INFINITE, 1)
                .toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openPickaxeBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lPioches§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.IRON_PICKAXE).setName("§f§lPioche de mineur").setPrice(1500).addEnchant(Enchantment.DIG_SPEED, 3).addEnchant(Enchantment.DURABILITY, 3).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_PICKAXE).setName("§f§lPioche des trouvailles").addEnchant(Enchantment.DURABILITY, 1).addEnchant(Enchantment.DIG_SPEED, 5).setPrice(3500).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§f§lPioche de mineur expérimenté").addEnchant(Enchantment.DIG_SPEED, 4).addEnchant(Enchantment.DURABILITY, 2).setPrice(4500).toItemStack());
        inv.setItem(19, new ItemBuilder(Material.GOLDEN_PICKAXE).setName("§6Pioche de mineuse").addEnchant(Enchantment.DIG_SPEED, 7).addEnchant(Enchantment.DURABILITY, 10).setPrice(5500).toItemStack());
        inv.setItem(21, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§bPioche Fortunéo").addEnchant(Enchantment.DIG_SPEED, 4).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).setPrice(7500).toItemStack());
        inv.setItem(23, new ItemBuilder(Material.NETHERITE_PICKAXE).setName("§c§lPioche du mineur parfait").addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.DURABILITY, 3).setPrice(15000).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openEffetMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lEffets§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        for (SellablePotions potions : SellablePotions.values()) {
            inv.setItem(potions.getSlot(), new ItemBuilder(Material.POTION)
                    .setName(potions.getName())
                    .setLore("", "§6Prix: " + potions.getOriginalPrice())
                    .setPotionEffect(new PotionEffect(potions.getEffectType(), Integer.MAX_VALUE, LotoxShop.getInstance().getPotionEffectLevel(player, potions.getEffectType()), false, false))
                    .toItemStack());
        }
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openConssomableMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lConssomables§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.ARROW).setAmount(4).setName("§r§fFlèche").setPrice(50).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.SPECTRAL_ARROW).setAmount(4).setName("§r§fFlèche Spectral").setPrice(150).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.ENDER_PEARL).setName("§r§fEnder Pearl").setAmount(1).setPrice(500).toItemStack());
        inv.setItem(19, new ItemBuilder(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE).setPrice(7500).toItemStack());
        inv.setItem(21, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setAmount(16).setPrice(1000).toItemStack());
        inv.setItem(23, new ItemBuilder(Material.FIREWORK_ROCKET).setAmount(4).setPrice(250).toItemStack());
        inv.setItem(25, new ItemBuilder(Material.GHAST_TEAR).setPrice(250).toItemStack());
        inv.setItem(29, new ItemBuilder(Material.TOTEM_OF_UNDYING).setAmount(1).setName("§r§fTotem de résurrection").setPrice(17500).toItemStack());
        inv.setItem(31, new ItemBuilder(Material.NAME_TAG).setPrice(500).toItemStack());
        inv.setItem(33, new ItemBuilder(Material.BONE_MEAL).setPrice(750).setAmount(5).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openBlocsMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lBlocs§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.DIRT).setAmount(32).setPrice(80).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.SAND).setAmount(32).setPrice(100).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.MAGMA_BLOCK).setAmount(16).setPrice(350).toItemStack());
        inv.setItem(19, new ItemBuilder(Material.SCAFFOLDING).setAmount(8).setPrice(750).toItemStack());
        inv.setItem(21, new ItemBuilder(Material.SEA_LANTERN).setAmount(8).setPrice(500).toItemStack());
        inv.setItem(23, new ItemBuilder(Material.RESPAWN_ANCHOR).setPrice(7500).toItemStack());
        inv.setItem(25, new ItemBuilder(Material.BEACON).setPrice(9000).toItemStack());
        inv.setItem(29, new ItemBuilder(Material.CONDUIT).setAmount(12).setPrice(1250).toItemStack());
        inv.setItem(31, new ItemBuilder(Material.SHULKER_BOX).setPrice(20000).toItemStack());
        inv.setItem(33, new ItemBuilder(Material.CHERRY_LOG).setPrice(5000).setAmount(48).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openFoodBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, " §c§n§lNouriturre§7 -§6" + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.COOKED_BEEF).setAmount(16).setPrice(450).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.COOKED_CHICKEN).setAmount(20).setPrice(250).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.PUFFERFISH).setAmount(4).setPrice(400).toItemStack());
        inv.setItem(29, new ItemBuilder(Material.GOLDEN_CARROT).setAmount(64).setPrice(1500).toItemStack());
        inv.setItem(31, new ItemBuilder(Material.GLISTERING_MELON_SLICE).setAmount(16).setPrice(500).toItemStack());
        inv.setItem(33, new ItemBuilder(Material.BAKED_POTATO).setAmount(16).setPrice(250).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openLeggingsBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lJambières§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.IRON_LEGGINGS).setName("§c§lJambières d'Elfe").setPrice(5000)
                .addEnchant(Enchantment.PROTECTION_PROJECTILE, 5)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.GOLDEN_LEGGINGS).setName("§eJambières §ed'Hermes").addEnchant(Enchantment.DURABILITY, 5).setPrice(5000).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openBootsBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lBottes§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(11, new ItemBuilder(Material.IRON_BOOTS).setName("§lBottes d'Elfe").setPrice(5000)
                .addEnchant(Enchantment.PROTECTION_PROJECTILE, 5)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§eBottes §ed'Hermes").setOnSeconde(event -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                int amountPiece = 0;
                for (ItemStack stack : p.getInventory().getArmorContents()) {
                    if (stack != null){
                        if (stack.hasItemMeta()){
                            if (Objects.requireNonNull(stack.getItemMeta()).hasDisplayName()){
                                if (stack.getItemMeta().getDisplayName().contains("§ed'Hermes")){
                                    amountPiece++;
                                }
                            }
                        }
                    }
                }
                if (amountPiece > 0){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, amountPiece-1, false, false));
                }
            }
        }).addEnchant(Enchantment.DURABILITY, 5).setPrice(5000).toItemStack());
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        player.openInventory(inv);
    }

    public void openAxeBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lHaches§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        inv.setItem(11, new ItemBuilder(Material.GOLDEN_AXE).setName("§c§lHache D'apprenti").setPrice(1500)
                .addEnchant(Enchantment.DIG_SPEED, 2)
                .addEnchant(Enchantment.DURABILITY, 1)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_AXE).setName("§c§lHache d'amateur").setPrice(2500)
                .addEnchant(Enchantment.DIG_SPEED, 3)
                .addEnchant(Enchantment.DURABILITY, 2)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND_AXE).setName("§c§lHache de mec tros cool").setPrice(4000)
                .addEnchant(Enchantment.DIG_SPEED, 4)
                .addEnchant(Enchantment.DURABILITY, 2)
                .toItemStack());
        inv.setItem(19, new ItemBuilder(Material.DIAMOND_AXE).setName("§c§lHache de bdg").setPrice(5000)
                .addEnchant(Enchantment.DIG_SPEED, 5)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());
        inv.setItem(21, new ItemBuilder(Material.WOODEN_AXE).setName("§c§lHache de pauvre").setPrice(500)
                .addEnchant(Enchantment.DIG_SPEED, 7)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());
        inv.setItem(23, new ItemBuilder(Material.IRON_AXE).setName("§c§lHache de gai").setPrice(3500)
                .addEnchant(Enchantment.DIG_SPEED, 3)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.SILK_TOUCH, 1)
                .toItemStack());
        player.openInventory(inv);
    }

    public void openShovelBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 5, "§c§n§lPelles§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        inv.setItem(11, new ItemBuilder(Material.GOLDEN_SHOVEL).setName("§c§lPelle d'apprenti").setPrice(1500)
                .addEnchant(Enchantment.DIG_SPEED, 2)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_SHOVEL).setName("§c§lPelle d'amateur").setPrice(3000)
                .addEnchant(Enchantment.DIG_SPEED, 3)
                .addEnchant(Enchantment.DURABILITY, 2)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND_SHOVEL).setName("§c§lPelle de fou").setPrice(5000)
                .addEnchant(Enchantment.DIG_SPEED, 5)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3)
                .toItemStack());
        inv.setItem(19, new ItemBuilder(Material.IRON_SHOVEL).setName("§c§lCoton tige").setPrice(2000)
                .addEnchant(Enchantment.DIG_SPEED, 3)
                .addEnchant(Enchantment.DURABILITY, 3)
                .toItemStack());

        player.openInventory(inv);
    }
    public void openFishingRodBuyMarketInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9 * 3, "§c§n§lRods§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        for (int i = 0; i <= 9; i += 7) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
            inv.setItem(i + 1, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 9; i <= 18; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 19; i <= 25; i += 6) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        for (int i = 17; i <= 26; i += 9) {
            inv.setItem(i, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setName(" ").toItemStack());
        }
        inv.setItem(11, new ItemBuilder(Material.FISHING_ROD).setName("§l§rRod d'Apprenti Pecheur").setPrice(500)
                .addEnchant(Enchantment.LUCK, 1)
                .addEnchant(Enchantment.DURABILITY, 1)
                .addEnchant(Enchantment.LURE, 1)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.FISHING_ROD).setName("§l§rRod de Pecheur Experimenté").setPrice(2500)
                .addEnchant(Enchantment.LUCK, 3)
                .addEnchant(Enchantment.DURABILITY, 3)
                .addEnchant(Enchantment.LURE, 3)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.FISHING_ROD).setName("§l§rRod de Poseidon").setPrice(15000)
                .addEnchant(Enchantment.LUCK, 10)
                .addEnchant(Enchantment.DURABILITY, 10)
                .addEnchant(Enchantment.LURE, 10)
                .toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
}
}
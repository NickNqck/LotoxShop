package fr.nicknqck.utils;


import fr.nicknqck.LotoxShop;
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

        inv.setItem(13, new ItemBuilder(Material.IRON_INGOT).setName("§r§fVendre tout").setAmount(64).toItemStack());
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
        inv.setItem(13, new ItemBuilder(Material.GOLD_INGOT).setName("§r§fVendre tout").setAmount(64).toItemStack());
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
        inv.setItem(13, new ItemBuilder(Material.DIAMOND).setName("§r§fVendre tout").setAmount(64).toItemStack());
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
        inv.setItem(13, new ItemBuilder(Material.EMERALD).setName("§r§fVendre tout").setAmount(64).toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }

    public void openSellMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§a§n§lVendre§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
        Inventory inv = getClassicInventory("§6§n§lMarket§r§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(21, SellMarket);
        inv.setItem(23, BuyMarket);
        player.openInventory(inv);
    }

    public void openBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lAcheter§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        Ranks rank = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank();
        Ranks futurRank = Ranks.getSuperiorRank(rank);
        if (futurRank != null){
            inv.setItem(11, futurRank.getItem());
        }
        if (rank.getLvl() >= 3){
            inv.setItem(13, new ItemBuilder(Material.ARMOR_STAND).setName("§r§fÉquipement").toItemStack());
        }
        inv.setItem(15, new ItemBuilder(Material.COOKED_BEEF).setName("§r§fNourriture").toItemStack());
        if (rank.getLvl() >= 4){
            inv.setItem(29, new ItemBuilder(Material.POTION).setLore("Pas encore développer...").hideAttributes(ItemFlag.HIDE_ADDITIONAL_TOOLTIP).setName("§r§fEffets").setPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 20 * 60 * 8, 0, false, false)).toItemStack());
        }
        inv.setItem(31, new ItemBuilder(Material.BRICKS).setName("§r§fBlocs").toItemStack());
        if (rank.getLvl() >= 1){
            inv.setItem(33, new ItemBuilder(Material.ARROW).setName("§r§fConssomable").toItemStack());
        }
        player.openInventory(inv);
    }

    public void openEquipementMarketInventory(Player player) {
        Ranks rank = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank();
        Inventory inv = getClassicInventory("§c§n§lÉquipement§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");

        if (rank.getLvl() >= 3) {
            inv.setItem(11, new ItemBuilder(Material.NETHERITE_SWORD).setName("§r§fÉpées").toItemStack());
            inv.setItem(19, new ItemBuilder(Material.NETHERITE_PICKAXE).setName("§r§fPioches").toItemStack());
            inv.setItem(29, new ItemBuilder(Material.BOW).setName("§r§fArcs").toItemStack());
            inv.setItem(21, new ItemBuilder(Material.NETHERITE_AXE).setName("§r§fHaches").toItemStack());
            inv.setItem(23, new ItemBuilder(Material.NETHERITE_SHOVEL).setName("§r§fPelles").toItemStack());
            inv.setItem(25, new ItemBuilder(Material.FISHING_ROD).setName("§r§fRods").toItemStack());
        }
        inv.setItem(13, new ItemBuilder(Material.NETHERITE_HELMET).setName("§r§fCasques").toItemStack());
        inv.setItem(15, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§r§fPlastrons").toItemStack());
        inv.setItem(31, new ItemBuilder(Material.NETHERITE_LEGGINGS).setName("§r§fJambières").toItemStack());
        inv.setItem(33, new ItemBuilder(Material.NETHERITE_BOOTS).setName("§r§fBottes").toItemStack());

        player.openInventory(inv);
    }

    public Inventory openSwordsBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lÉpées§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.DIAMOND_SWORD).setName("§c§lSword of Kratos").setPrice(6000)
                .addEnchant(Enchantment.SHARPNESS, 4)
                .addEnchant(Enchantment.FIRE_ASPECT, 3)
                .addEnchant(Enchantment.UNBREAKING, 2)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.WOODEN_SWORD).setName("§c§lSword of apprentice").setPrice(500)
                .addEnchant(Enchantment.SHARPNESS, 3)
                .addEnchant(Enchantment.UNBREAKING, 2)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.IRON_SWORD).setName("§c§aAmateur sword").setPrice(2500)
                .addEnchant(Enchantment.SHARPNESS, 4)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                .toItemStack());
        inv.setItem(21, new ItemBuilder(Material.DIAMOND_SWORD).setName("§c§lExperienced Sword").setPrice(7500)
                .addEnchant(Enchantment.SHARPNESS, 4)
                .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                .addEnchant(Enchantment.UNBREAKING, 2)
                .addEnchant(Enchantment.LOOTING, 2)
                .toItemStack());
        if (getRankLvL(player) > 4) {
            inv.setItem(23, new ItemBuilder(Material.IRON_SWORD).setName("§c§lSword of Zeus").setPrice(15000)
                    .addEnchant(Enchantment.SHARPNESS, 3)
                    .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                    .addEnchant(Enchantment.UNBREAKING, 3)
                    .addEnchant(Enchantment.LOOTING, 3)
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
                    .addEnchant(Enchantment.SHARPNESS, 3)
                    .addEnchant(Enchantment.SWEEPING_EDGE, 3)
                    .addEnchant(Enchantment.UNBREAKING, 3)
                    .addEnchant(Enchantment.LOOTING, 3)
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
            inv.setItem(19, new ItemBuilder(Material.IRON_SWORD).addEnchant(Enchantment.SHARPNESS, 6).setName("§c§lÉpée §c§ld'Arès").setPrice(10000).addEnchant(Enchantment.UNBREAKING, 3).addEnchant(Enchantment.BANE_OF_ARTHROPODS, 3).addEnchant(Enchantment.SMITE, 3).toItemStack());
        }
        return inv;
    }

    public void openHelmetsBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lCasques§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.IRON_HELMET).setName("§c§lCasque d'elfe").setLore("", "§6Prix: " + 2500 + " coins")
                .addEnchant(Enchantment.PROJECTILE_PROTECTION, 5)
                .addEnchant(Enchantment.RESPIRATION, 3)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .toItemStack());
        if (getRankLvL(player) > 3){
            inv.setItem(13, new ItemBuilder(Material.GOLDEN_HELMET).setName("§eCasque §ed'Hermes").addEnchant(Enchantment.UNBREAKING, 5).setPrice(5000).toItemStack());
        }
        if (getRankLvL(player) > 4){
            inv.setItem(15, new ItemBuilder(Material.IRON_HELMET).setName("§c§lCasque §c§ld'Arès").addEnchant(Enchantment.UNBREAKING, 3).addEnchant(Enchantment.FIRE_PROTECTION, 3).addEnchant(Enchantment.THORNS, 1).addEnchant(Enchantment.PROTECTION, 3).setPrice(10000).toItemStack());
        }
        player.openInventory(inv);
    }

    public void openChestPlateBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lPlastrons§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.IRON_CHESTPLATE).setName("§c§lPlastron d'elfe").setLore("", "§6Prix: " + 7500 + " coins")
                .addEnchant(Enchantment.PROJECTILE_PROTECTION, 5)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .toItemStack());
        if (getRankLvL(player) > 3){
            inv.setItem(13, new ItemBuilder(Material.GOLDEN_CHESTPLATE).setName("§ePlastron §ed'Hermes").addEnchant(Enchantment.UNBREAKING, 5).setPrice(5000).toItemStack());
        }
        if (getRankLvL(player) >4) {
            inv.setItem(15, new ItemBuilder(Material.IRON_CHESTPLATE).setName("§c§lPlastron §c§ld'Arès").addEnchant(Enchantment.UNBREAKING, 3).addEnchant(Enchantment.BLAST_PROTECTION, 3).addEnchant(Enchantment.THORNS, 1).addEnchant(Enchantment.PROTECTION, 3).setPrice(10000).toItemStack());
        }
        player.openInventory(inv);
    }

    public void openBowBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lArc§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.BOW).setName("§c§lArc d'Elfe").addPrice(22000)
                .addEnchant(Enchantment.POWER, 7)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .toItemStack());
        player.openInventory(inv);
    }

    public void openPickaxeBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lPioches§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.IRON_PICKAXE).setName("§f§lPioche de mineur").setPrice(1500).addEnchant(Enchantment.EFFICIENCY, 3).addEnchant(Enchantment.UNBREAKING, 3).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_PICKAXE).setName("§f§lPioche des trouvailles").addEnchant(Enchantment.UNBREAKING, 1).addEnchant(Enchantment.EFFICIENCY, 5).setPrice(3500).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§f§lPioche de mineur expérimenté").addEnchant(Enchantment.EFFICIENCY, 4).addEnchant(Enchantment.UNBREAKING, 2).setPrice(4500).toItemStack());
        inv.setItem(19, new ItemBuilder(Material.GOLDEN_PICKAXE).setName("§6Pioche de mineuse").addEnchant(Enchantment.EFFICIENCY, 7).addEnchant(Enchantment.UNBREAKING, 10).setPrice(5500).toItemStack());
        if (LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank().getLvl() > 4) {
            inv.setItem(21, new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§bPioche Fortunéo").addEnchant(Enchantment.EFFICIENCY, 2).addEnchant(Enchantment.FORTUNE, 3).setPrice(9200).toItemStack());
            inv.setItem(23, new ItemBuilder(Material.NETHERITE_PICKAXE).setName("§c§lPioche du mineur expérimenté améliorier").addEnchant(Enchantment.EFFICIENCY, 5).addEnchant(Enchantment.UNBREAKING, 3).setPrice(15000).toItemStack());
        }
        player.openInventory(inv);
    }

    public void openConssomableMarketInventory(Player player) {
        Ranks rank = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank();
        Inventory inv = getClassicInventory("§c§n§lConssomables§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.ARROW).setAmount(4).setName("§r§fFlèche").setPrice(50).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.SPECTRAL_ARROW).setAmount(4).setName("§r§fFlèche Spectral").setPrice(150).toItemStack());
        if (rank.getLvl() >= 2){
            inv.setItem(15, new ItemBuilder(Material.ENDER_PEARL).setName("§r§fEnder Pearl").setAmount(1).setPrice(500).toItemStack());
            inv.setItem(25, new ItemBuilder(Material.GHAST_TEAR).setPrice(250).toItemStack());
            inv.setItem(31, new ItemBuilder(Material.NAME_TAG).setPrice(500).toItemStack());
            inv.setItem(33, new ItemBuilder(Material.BONE_MEAL).setPrice(750).setAmount(5).toItemStack());
        }
        if (rank.getLvl() >= 3){
            inv.setItem(21, new ItemBuilder(Material.EXPERIENCE_BOTTLE).setAmount(16).setPrice(1000).toItemStack());
            inv.setItem(23, new ItemBuilder(Material.FIREWORK_ROCKET).setAmount(4).setPrice(250).toItemStack());
        }
        if (rank.getLvl() >= 4) {
            inv.setItem(19, new ItemBuilder(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE).setPrice(9500).toItemStack());
            inv.setItem(29, new ItemBuilder(Material.TOTEM_OF_UNDYING).setAmount(1).setName("§r§fTotem de résurrection").setPrice(17500).toItemStack());
        }
        player.openInventory(inv);
    }

    public void openBlocsMarketInventory(Player player) {
        Ranks rank = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank();
        Inventory inv = getClassicInventory("§c§n§lBlocs§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.DIRT).setAmount(32).setPrice(80).toItemStack());
        inv.setItem(13, new ItemBuilder(Material.SAND).setAmount(32).setPrice(100).toItemStack());
        if (rank.getLvl() >= 1) {
            inv.setItem(15, new ItemBuilder(Material.MAGMA_BLOCK).setAmount(16).setPrice(350).toItemStack());
            inv.setItem(19, new ItemBuilder(Material.SCAFFOLDING).setAmount(8).setPrice(750).toItemStack());
        }
        if (rank.getLvl() >= 2){
            inv.setItem(21, new ItemBuilder(Material.SEA_LANTERN).setAmount(8).setPrice(500).toItemStack());
            inv.setItem(33, new ItemBuilder(Material.CHERRY_LOG).setPrice(5000).setAmount(32).toItemStack());
        }
        if (rank.getLvl() >= 3){
            inv.setItem(25, new ItemBuilder(Material.BEACON).setPrice(4500).toItemStack());
            inv.setItem(29, new ItemBuilder(Material.ANCIENT_DEBRIS).setPrice(15000/2).toItemStack());
        }
        if (rank.getLvl() >= 4) {
            inv.setItem(23, new ItemBuilder(Material.RESPAWN_ANCHOR).setPrice(7500).toItemStack());
            inv.setItem(31, new ItemBuilder(Material.SHULKER_BOX).setPrice(20000).toItemStack());
        }
        player.openInventory(inv);
    }

    public void openFoodBuyMarketInventory(Player player) {
        Ranks rank = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank();
        Inventory inv = getClassicInventory(" §c§n§lNouriturre§7 -§6" + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        if (rank.getLvl() >= 1){
            inv.setItem(11, new ItemBuilder(Material.COOKED_BEEF).setAmount(16).setPrice(450).toItemStack());
            inv.setItem(33, new ItemBuilder(Material.BAKED_POTATO).setAmount(16).setPrice(250).toItemStack());
        }
        inv.setItem(13, new ItemBuilder(Material.COOKED_CHICKEN).setAmount(20).setPrice(250).toItemStack());
        inv.setItem(15, new ItemBuilder(Material.PUFFERFISH).setAmount(4).setPrice(400).toItemStack());
        if (rank.getLvl() >= 3) {
            inv.setItem(29, new ItemBuilder(Material.GOLDEN_CARROT).setAmount(64).setPrice(1500).toItemStack());
        }
        if (rank.getLvl() >= 2){
            inv.setItem(31, new ItemBuilder(Material.GLISTERING_MELON_SLICE).setAmount(16).setPrice(500).toItemStack());
        }
        player.openInventory(inv);
    }

    public void openLeggingsBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lJambières§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
                .addEnchant(Enchantment.PROJECTILE_PROTECTION, 5)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .toItemStack());
        if (getRankLvL(player) > 3) {
            inv.setItem(13, new ItemBuilder(Material.GOLDEN_LEGGINGS).setName("§eJambières §ed'Hermes").addEnchant(Enchantment.UNBREAKING, 5).setPrice(5000).toItemStack());
        }
        if (getRankLvL(player) > 4) {
            inv.setItem(15, new ItemBuilder(Material.IRON_LEGGINGS).setName("§c§lJambières §c§ld'Arès").addEnchant(Enchantment.UNBREAKING, 3).addEnchant(Enchantment.BLAST_PROTECTION, 3).addEnchant(Enchantment.THORNS, 1).addEnchant(Enchantment.PROTECTION, 3).setPrice(10000).toItemStack());
        }
        player.openInventory(inv);
    }

    public Inventory openBootsBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lBottes§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
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
                .addEnchant(Enchantment.PROJECTILE_PROTECTION, 5)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .toItemStack());
        if (getRankLvL(player) > 3) {
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
            }).addEnchant(Enchantment.UNBREAKING, 5).setPrice(5000).toItemStack());
        }
        if (getRankLvL(player) > 4) {
            inv.setItem(15, new ItemBuilder(Material.IRON_BOOTS).setName("§c§lBottes §c§ld'Arès").setOnDamage(event -> {
                Player p = (Player) event.getDamager();
                int amountPiece = 0;
                ItemStack item = p.getInventory().getItemInMainHand();
                for (ItemStack stack : p.getInventory().getArmorContents()) {
                    if (stack != null){
                        if (stack.hasItemMeta()){
                            if (Objects.requireNonNull(stack.getItemMeta()).hasDisplayName()){
                                if (stack.getItemMeta().getDisplayName().contains("§c§ld'Arès")){
                                    amountPiece++;
                                }
                            }
                        }
                    }
                }
                if (item.hasItemMeta()){
                    if (Objects.requireNonNull(item.getItemMeta()).hasDisplayName()){
                        if (item.getItemMeta().getDisplayName().contains(" §c§ld'Arès")){
                            amountPiece++;
                        }
                    }
                }
                if (amountPiece > 0){
                    double boost = 1.0 + (amountPiece *0.1);

                    System.out.println(boost+ "//"+event.getDamage());
                    event.setDamage(event.getDamage()*boost);
                    System.out.println(event.getDamage());
                }
            }).addEnchant(Enchantment.UNBREAKING, 3).addEnchant(Enchantment.BLAST_PROTECTION, 3).addEnchant(Enchantment.THORNS, 1).addEnchant(Enchantment.PROTECTION, 3).setPrice(10000).toItemStack());
        }
        return inv;
    }

    public void openAxeBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lHaches§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.GOLDEN_AXE).setName("§c§lHache D'apprenti").setPrice(1500)
                .addEnchant(Enchantment.EFFICIENCY, 2)
                .addEnchant(Enchantment.UNBREAKING, 1)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_AXE).setName("§c§lHache d'amateur").setPrice(2500)
                .addEnchant(Enchantment.EFFICIENCY, 3)
                .addEnchant(Enchantment.UNBREAKING, 2)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND_AXE).setName("§c§lHache de mec tros cool").setPrice(4000)
                .addEnchant(Enchantment.EFFICIENCY, 4)
                .addEnchant(Enchantment.UNBREAKING, 2)
                .toItemStack());
        inv.setItem(19, new ItemBuilder(Material.DIAMOND_AXE).setName("§c§lHache de bdg").setPrice(5000)
                .addEnchant(Enchantment.EFFICIENCY, 5)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .toItemStack());
        inv.setItem(21, new ItemBuilder(Material.WOODEN_AXE).setName("§c§lHache de pauvre").setPrice(500)
                .addEnchant(Enchantment.EFFICIENCY, 7)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .toItemStack());
        inv.setItem(23, new ItemBuilder(Material.IRON_AXE).setName("§c§lHache de gai").setPrice(3500)
                .addEnchant(Enchantment.EFFICIENCY, 3)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .addEnchant(Enchantment.SILK_TOUCH, 1)
                .toItemStack());
        player.openInventory(inv);
    }

    public void openShovelBuyMarketInventory(Player player) {
        Inventory inv = getClassicInventory("§c§n§lPelles§7 -§6 " + LotoxShop.getInstance().getStringCoins(player.getUniqueId()) + " coins");
        inv.setItem(11, new ItemBuilder(Material.GOLDEN_SHOVEL).setName("§c§lPelle d'apprenti").setPrice(1500)
                .addEnchant(Enchantment.EFFICIENCY, 2)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.IRON_SHOVEL).setName("§c§lPelle d'amateur").setPrice(3000)
                .addEnchant(Enchantment.EFFICIENCY, 3)
                .addEnchant(Enchantment.UNBREAKING, 2)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.DIAMOND_SHOVEL).setName("§c§lPelle de fou").setPrice(5000)
                .addEnchant(Enchantment.EFFICIENCY, 5)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .addEnchant(Enchantment.FORTUNE, 3)
                .toItemStack());
        inv.setItem(19, new ItemBuilder(Material.IRON_SHOVEL).setName("§c§lCoton tige").setPrice(2000)
                .addEnchant(Enchantment.EFFICIENCY, 3)
                .addEnchant(Enchantment.UNBREAKING, 3)
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
                .addEnchant(Enchantment.LUCK_OF_THE_SEA, 1)
                .addEnchant(Enchantment.UNBREAKING, 1)
                .addEnchant(Enchantment.LURE, 1)
                .toItemStack());
        inv.setItem(13, new ItemBuilder(Material.FISHING_ROD).setName("§l§rRod de Pecheur Experimenté").setPrice(2500)
                .addEnchant(Enchantment.LUCK_OF_THE_SEA, 3)
                .addEnchant(Enchantment.UNBREAKING, 3)
                .addEnchant(Enchantment.LURE, 3)
                .toItemStack());
        inv.setItem(15, new ItemBuilder(Material.FISHING_ROD).setName("§l§rRod de Poseidon").setPrice(15000)
                .addEnchant(Enchantment.LUCK_OF_THE_SEA, 10)
                .addEnchant(Enchantment.UNBREAKING, 10)
                .addEnchant(Enchantment.LURE, 10)
                .toItemStack());
        inv.setItem(22, getReturnArrow());
        player.openInventory(inv);
    }
    private Inventory getClassicInventory(String name){
        Inventory inv = Bukkit.createInventory(null, 9*5, name);
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
        inv.setItem(40, new ItemBuilder(Material.ARROW).setName("§6Retour").toItemStack());
        return inv;
    }
    private int getRankLvL(Player player) {
        return LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank().getLvl();
    }
}
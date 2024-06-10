package fr.nicknqck;

import fr.nicknqck.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class MarketCommand implements CommandExecutor, Listener {
    private final ItemStack SellMarket =  new ItemBuilder(Material.COAL_ORE).setName("§r§aVendre").toItemStack();
    public MarketCommand(){
        Bukkit.getServer().getPluginManager().registerEvents(this, LotoxShop.getInstance());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player player){
            if (args.length == 0){
                openBasicMarketInventory(player);
                return true;
            } else {
                if (args.length == 3){
                    if (args[0].equalsIgnoreCase("set")){
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null){
                            if (LotoxShop.getShopContainer().containsKey(target.getUniqueId())){
                                if (args[2] != null){
                                    System.out.println(args[2]);
                                    LotoxShop.getInstance().setCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("add")) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null){
                            if (LotoxShop.getShopContainer().containsKey(target.getUniqueId())){
                                if (args[2] != null){
                                    System.out.println(args[2]);
                                    LotoxShop.getInstance().addCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Impossible de faire cette commande via la console");
        return false;
    }
    private void openBasicMarketInventory(Player player){
        if (!LotoxShop.getShopContainer().containsKey(player.getUniqueId())){
            LotoxShop.getShopContainer().put(player.getUniqueId(), 0);
        }
        Inventory inv = Bukkit.createInventory(player, 9*5, "§6§n§lMarket§r§7 -§6 "+LotoxShop.getShopContainer().get(player.getUniqueId())+" coins");
        inv.setItem(20, SellMarket);
        player.openInventory(inv);
    }
    @EventHandler
    private void onInventoryClick(InventoryClickEvent event){
        if (event.getClickedInventory() == null)return;
        if (event.getCurrentItem() == null)return;
        if (event.getCurrentItem().getType().equals(Material.AIR))return;
        if (event.getCurrentItem().getType().name().contains("GLASS")) {
            event.setCancelled(true);
            return;
        }
        if (event.getWhoClicked() instanceof Player player){
            String name = event.getView().getTitle();
            ItemStack item = event.getCurrentItem();
            if (name.contains("§6§n§lMarket§r§7 -§6 ")){//donc l'inv est celui que j'ai créer
                if (item.isSimilar(SellMarket)){
                    openSellMarketInventory(player);
                    event.setCancelled(true);
                }
            } else if (name.contains("§a§n§lVendre§7 -§6 ")){
                switch (item.getType()){
                    case IRON_INGOT:
                        openIronSellInventory(player);
                        break;
                    case GOLD_INGOT:
                        openGoldSellInventory(player);
                        break;
                    case DIAMOND:
                        openDiamondSellInventory(player);
                        break;
                    case EMERALD:
                        openEmeraldSellInventory(player);
                        break;
                }
                event.setCancelled(true);
            } else if (name.contains("§f§n§lFer§7 -§6 ")){
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.IRON_INGOT);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.IRON_INGOT, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*10));
                }
                player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*10)+"💰");
                openIronSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§6§n§lOr§7 -§6 ")) {
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.GOLD_INGOT);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.GOLD_INGOT, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*50));
                }
                player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*50)+"💰");
                openGoldSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§b§n§lDiamant§7 -§6 ")) {
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.DIAMOND);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.DIAMOND, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*100));
                }
                player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*100)+"💰");
                openDiamondSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§a§n§lÉmeraude§7 -§6 ")) {
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.EMERALD);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.EMERALD, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*200));
                }
                player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*200)+"💰");//   https://minecraft.tools/fr/color-code.php
                openEmeraldSellInventory(player);
                event.setCancelled(true);
            }
        }
    }
    private void openIronSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§f§n§lFer§7 -§6 "+LotoxShop.getShopContainer().get(player.getUniqueId())+" coins");
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
        player.openInventory(inv);
    }
    private void openGoldSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§6§n§lOr§7 -§6 "+LotoxShop.getShopContainer().get(player.getUniqueId())+" coins");
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
        player.openInventory(inv);
    }
    private void openDiamondSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§b§n§lDiamant§7 -§6 "+LotoxShop.getShopContainer().get(player.getUniqueId())+" coins");
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
        player.openInventory(inv);
    }
    private void openEmeraldSellInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9*3, "§a§n§lÉmeraude§7 -§6 "+LotoxShop.getShopContainer().get(player.getUniqueId())+" coins");
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
        player.openInventory(inv);
    }
    private void openSellMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§a§n§lVendre§7 -§6 "+LotoxShop.getShopContainer().get(player.getUniqueId())+" coins");
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
        inv.setItem(19, new ItemBuilder(Material.IRON_INGOT).setAmount(1).setName("§r§fFer").toItemStack());
        inv.setItem(21, new ItemBuilder(Material.GOLD_INGOT).setAmount(1).setName("§r§6Or").toItemStack());
        inv.setItem(23, new ItemBuilder(Material.DIAMOND).setAmount(1).setName("§r§bDiamant").toItemStack());
        inv.setItem(25, new ItemBuilder(Material.EMERALD).setAmount(1).setName("§r§aÉmeraude").toItemStack());
        player.openInventory(inv);
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
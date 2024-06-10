package fr.nicknqck;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class MarketCommand implements CommandExecutor, Listener {

    public MarketCommand(){
        Bukkit.getServer().getPluginManager().registerEvents(this, LotoxShop.getInstance());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player player){
            if (args.length == 0){
                LotoxShop.getInstance().getInventories().openBasicMarketInventory(player);
                return true;
            } else {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("list")){

                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("get")) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null){
                            if (LotoxShop.getInstance().getPlayerDataMap().containsKey(target.getUniqueId())){
                                    player.sendMessage("§c"+target.getName()+"§f possède§a "+LotoxShop.getInstance().getPlayerDataMap().get(target.getUniqueId())+" coins");
                                    System.out.println("target: "+target.getName()+" has actually "+LotoxShop.getInstance().getPlayerDataMap().get(target.getUniqueId())+" coins");
                                    return true;
                            }
                        }
                    }
                } else if (args.length == 3){
                    if (args[0].equalsIgnoreCase("set")){
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null && player.isOp()){
                            if (LotoxShop.getInstance().getPlayerDataMap().containsKey(target.getUniqueId())){
                                if (args[2] != null){
                                    System.out.println(args[2]);
                                    LotoxShop.getInstance().setCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("add")) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null && player.isOp()){
                            if (LotoxShop.getInstance().getPlayerDataMap().containsKey(target.getUniqueId())){
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
            if (name.contains("§6§n§lMarket§r§7 -§6 ")){
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getSellMarket())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    event.setCancelled(true);
                }
            } else if (name.contains("§a§n§lVendre§7 -§6 ")){
                switch (item.getType()){
                    case IRON_INGOT:
                        LotoxShop.getInstance().getInventories().openIronSellInventory(player);
                        break;
                    case GOLD_INGOT:
                        LotoxShop.getInstance().getInventories().openGoldSellInventory(player);
                        break;
                    case DIAMOND:
                        LotoxShop.getInstance().getInventories().openDiamondSellInventory(player);
                        break;
                    case EMERALD:
                        LotoxShop.getInstance().getInventories().openEmeraldSellInventory(player);
                        break;
                    case ARROW:
                        LotoxShop.getInstance().getInventories().openBasicMarketInventory(player);
                        break;
                }
                event.setCancelled(true);
            } else if (name.contains("§f§n§lFer§7 -§6 ")){
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.IRON_INGOT);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.IRON_INGOT, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*10));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*10)+"💰");
                }
                LotoxShop.getInstance().getInventories().openIronSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§6§n§lOr§7 -§6 ")) {
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.GOLD_INGOT);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.GOLD_INGOT, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*50));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*50)+"💰");
                }
                LotoxShop.getInstance().getInventories().openGoldSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§b§n§lDiamant§7 -§6 ")) {
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.DIAMOND);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.DIAMOND, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*100));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*100)+"💰");
                }
                LotoxShop.getInstance().getInventories().openDiamondSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§a§n§lÉmeraude§7 -§6 ")) {
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT = getItemAmount(player, Material.EMERALD);
                if (amount <= zAMOUNT){
                    removeItem(player, Material.EMERALD, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (amount*200));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(amount*200)+"💰");//   https://minecraft.tools/fr/color-code.php
                }
                LotoxShop.getInstance().getInventories().openEmeraldSellInventory(player);
                event.setCancelled(true);
            }
        }
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
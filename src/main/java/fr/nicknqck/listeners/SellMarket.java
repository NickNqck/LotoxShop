package fr.nicknqck.listeners;

import fr.nicknqck.LotoxShop;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SellMarket implements Listener {

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event){
        if (event.getClickedInventory() == null)return;
        if (event.getCurrentItem() == null)return;
        if (event.getCurrentItem().getType().equals(Material.AIR))return;
        if (event.getWhoClicked() instanceof Player player){
            String name = event.getView().getTitle();
            ItemStack item = event.getCurrentItem();
            if (name.contains("§a§n§lVendre§7 -§6 ")){
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
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
            } else if (name.contains("§a§n§lFer§7 -§6 ")){
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT = LotoxShop.getInstance().getItemAmount(player, Material.IRON_INGOT);
                if (amount <= zAMOUNT){
                    ItemStack sell = LotoxShop.getInstance().removeItem(player, Material.IRON_INGOT, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (sell.getAmount()*10));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(sell.getAmount()*10)+"💰");
                }
                LotoxShop.getInstance().getInventories().openIronSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§a§n§lOr§7 -§6 ")) {
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT = LotoxShop.getInstance().getItemAmount(player, Material.GOLD_INGOT);
                if (amount <= zAMOUNT){
                    ItemStack sell = LotoxShop.getInstance().removeItem(player, Material.GOLD_INGOT, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (sell.getAmount()*50));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(sell.getAmount()*50)+"💰");
                }
                LotoxShop.getInstance().getInventories().openGoldSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§a§n§lDiamant§7 -§6 ")) {
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT = LotoxShop.getInstance().getItemAmount(player, Material.DIAMOND);
                if (amount <= zAMOUNT){
                    ItemStack sell = LotoxShop.getInstance().removeItem(player, Material.DIAMOND, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (sell.getAmount()*150));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(sell.getAmount()*150)+"💰");
                }
                LotoxShop.getInstance().getInventories().openDiamondSellInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§a§n§lÉmeraude§7 -§6 ")) {
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    return;
                }
                int amount = item.getAmount();
                int zAMOUNT =LotoxShop.getInstance(). getItemAmount(player, Material.EMERALD);
                if (amount <= zAMOUNT){
                    ItemStack sell = LotoxShop.getInstance().removeItem(player, Material.EMERALD, amount);
                    LotoxShop.getInstance().addCoins(player.getUniqueId(), (sell.getAmount()*100));
                    player.sendMessage("§aSuite a votre vente,vos gains s'elèvent a §6"+(sell.getAmount()*100)+"💰");
                }
                LotoxShop.getInstance().getInventories().openEmeraldSellInventory(player);
                event.setCancelled(true);
            }
        }
    }
}
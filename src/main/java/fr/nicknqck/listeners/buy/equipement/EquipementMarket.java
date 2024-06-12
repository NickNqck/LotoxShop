package fr.nicknqck.listeners.buy.equipement;

import fr.nicknqck.LotoxShop;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class EquipementMarket implements Listener {

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
            if (!item.hasItemMeta())return;
            if (name.contains("§c§n§lÉquipement§7 -§6 ")){
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                switch (item.getType()){
                    case NETHERITE_SWORD:
                        LotoxShop.getInstance().getInventories().openSwordsBuyMarketInventory(player);
                        break;
                    case NETHERITE_HELMET:
                        LotoxShop.getInstance().getInventories().openHelmetsBuyMarketInventory(player);
                        break;
                    case NETHERITE_CHESTPLATE:
                        LotoxShop.getInstance().getInventories().openChestPlateBuyMarketInventory(player);
                        break;
                    case BOW:
                        LotoxShop.getInstance().getInventories().openBowBuyMarketInventory(player);
                        break;
                }
                event.setCancelled(true);
            } else if (name.contains("§c§n§lÉpées§7 -§6 ")){
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                LotoxShop.getInstance().trySelling(player, item);
                LotoxShop.getInstance().getInventories().openSwordsBuyMarketInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§c§n§lPlastrons§7 -§6 ")){
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                LotoxShop.getInstance().trySelling(player, item);
                LotoxShop.getInstance().getInventories().openChestPlateBuyMarketInventory(player);
                event.setCancelled(true);
            }else if (name.contains("§c§n§lCasques§7 -§6 ")) {
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())) {
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                LotoxShop.getInstance().trySelling(player, item);
                LotoxShop.getInstance().getInventories().openHelmetsBuyMarketInventory(player);
                event.setCancelled(true);
            } else if (name.contains("§c§n§lBow§7 -§6 ")) {
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())) {
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                LotoxShop.getInstance().trySelling(player, item);
                LotoxShop.getInstance().getInventories().openBowBuyMarketInventory(player);
                event.setCancelled(true);
            }
        }
    }

}

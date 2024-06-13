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
                int zAMOUNT = LotoxShop.getInstance().getItemAmount(player, Material.IRON_INGOT);
                player.getInventory().remove(item.getType());
                int sell = zAMOUNT*10;
                LotoxShop.getInstance().addCoins(player.getUniqueId(), sell);
                player.sendMessage("§aVotre vente vous a fait gagner, §6"+sell+" coins");
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
                int zAMOUNT = LotoxShop.getInstance().getItemAmount(player, Material.GOLD_INGOT);
                player.getInventory().remove(item.getType());
                int sell = zAMOUNT*50;
                LotoxShop.getInstance().addCoins(player.getUniqueId(), sell);
                player.sendMessage("§aVotre vente vous a fait gagner, §6"+sell+" coins");
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
                int zAMOUNT = LotoxShop.getInstance().getItemAmount(player, Material.DIAMOND);
                player.getInventory().remove(item.getType());
                int sell = zAMOUNT*150;
                LotoxShop.getInstance().addCoins(player.getUniqueId(), sell);
                player.sendMessage("§aVotre vente vous a fait gagner, §6"+sell+" coins");
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
                int zAMOUNT = LotoxShop.getInstance().getItemAmount(player, Material.EMERALD);
                player.getInventory().remove(item.getType());
                int sell = zAMOUNT*100;
                LotoxShop.getInstance().addCoins(player.getUniqueId(), sell);
                player.sendMessage("§aVotre vente vous a fait gagner, §6"+sell+" coins");
                LotoxShop.getInstance().getInventories().openEmeraldSellInventory(player);
                event.setCancelled(true);
            }
        }
    }
}
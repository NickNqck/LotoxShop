package fr.nicknqck.listeners.buy;

import fr.nicknqck.LotoxShop;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BuyMarket implements Listener {

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event){
        if (event.getClickedInventory() == null)return;
        if (event.getCurrentItem() == null)return;
        if (event.getCurrentItem().getType().equals(Material.AIR))return;
        if (event.getWhoClicked() instanceof Player player){
            String name = event.getView().getTitle();
            ItemStack item = event.getCurrentItem();
            if (!item.hasItemMeta())return;
            if (name.contains("§c§n§lAcheter§7 -§6 ")){
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openBasicMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                switch (item.getType()){
                    case BOOK,POTION:
                        player.sendMessage("§cFeature pas encore dev...");
                        break;
                    case ARMOR_STAND:
                        LotoxShop.getInstance().getInventories().openEquipementMarketInventory(player);
                        break;
                    case ARROW:
                        LotoxShop.getInstance().getInventories().openConssomableMarketInventory(player);
                        break;
                    case BRICKS:
                        LotoxShop.getInstance().getInventories().openBlocsMarketInventory(player);
                        break;
                    case COOKED_BEEF:
                        LotoxShop.getInstance().getInventories().openFoodBuyMarketInventory(player);
                        break;
                }
                event.setCancelled(true);
            }
        }
    }

}

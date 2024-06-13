package fr.nicknqck.listeners.buy.blocs;

import fr.nicknqck.LotoxShop;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BlocsMarket implements Listener {

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event){
        if (event.getClickedInventory() == null)return;
        if (event.getCurrentItem() == null)return;
        if (event.getCurrentItem().getType().equals(Material.AIR))return;
        if (event.getWhoClicked() instanceof Player player){
            String name = event.getView().getTitle();
            ItemStack item = event.getCurrentItem();
            if (name.contains("§c§n§lBlocs§7 -§6 ")){
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                LotoxShop.getInstance().tryBuying(player, item);
                LotoxShop.getInstance().getInventories().openBlocsMarketInventory(player);
                event.setCancelled(true);
            }
        }
    }
}

package fr.nicknqck.listeners.buy.conssumable;

import fr.nicknqck.LotoxShop;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ConssomableMarket implements Listener {

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
            if (name.contains("§c§n§lConssomables§7 -§6 ")){
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())){
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                LotoxShop.getInstance().trySelling(player, item);
                LotoxShop.getInstance().getInventories().openConssomableMarketInventory(player);
                event.setCancelled(true);
            }
        }
    }

}

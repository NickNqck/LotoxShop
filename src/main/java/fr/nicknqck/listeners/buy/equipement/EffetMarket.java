package fr.nicknqck.listeners.buy.equipement;

import fr.nicknqck.LotoxShop;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;

public class EffetMarket implements Listener {

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
            if (name.contains("§c§n§lEffets§7 -§6 ")){
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getReturnArrow())) {
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                    return;
                }
                if (item.getType().equals(Material.POTION)){
                    try {
                        @SuppressWarnings("deprecation")
                        Potion potion = Potion.fromItemStack(item);

                        PotionEffectType potionEffectType = potion.getType().getEffectType();
                        int playerPotionLevel = LotoxShop.getInstance().getPotionEffectLevel(player, potionEffectType);
                        int maxPotionLevel = SellablePotions.getSellable(potionEffectType).getMax();

                        if (playerPotionLevel < maxPotionLevel) {
                            if (LotoxShop.getInstance().sellItem(player, item, false)) {
                                LotoxShop.getInstance().addEffects(player.getUniqueId(), potionEffectType);
                            } else {
                                player.sendMessage("§cVous n'avez pas assez d'argent !");
                            }
                        } else {
                            player.sendMessage("§cVous avez déjà atteint le niveau maximum pour cet effet de potion !");
                        }

                        LotoxShop.getInstance().getInventories().openEffetMarketInventory(player);
                        event.setCancelled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        event.getWhoClicked().sendMessage("§cUne erreur est survenue lors de l'achat de la potion. Veuillez réessayer.");
                    }
                }
                LotoxShop.getInstance().getInventories().openEffetMarketInventory(player);
                event.setCancelled(true);
            }
        }
    }

}

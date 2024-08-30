package fr.nicknqck.listeners;

import fr.mrmicky.fastboard.FastBoard;
import fr.nicknqck.LotoxShop;
import fr.nicknqck.listeners.customevents.EquipementChangeEvent;
import fr.nicknqck.listeners.customevents.onSecondEvent;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class PlayerListeners implements Listener{
    @Getter
    private static PlayerListeners instance;
    @Getter
    private final List<Consumer<onSecondEvent> > onSecondConsumers = new ArrayList<>();
    @Getter
    private final List<Consumer<EntityDamageByEntityEvent>> onEntityDamageByEntityConsumers = new ArrayList<>();
    @Getter
    private final List<Consumer<EquipementChangeEvent>> onEquipementChange = new ArrayList<>();
    public PlayerListeners(){
        instance = this;
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        onBoardJoin(player);
    }
    public static void onBoardJoin(Player player){
        LotoxShop.getInstance().addCoins(player.getUniqueId(), 0);
        FastBoard board = new FastBoard(player);

        board.updateTitle("§cQuoiCouSurvie");

        LotoxShop.getInstance().getBoards().put(player.getUniqueId(), board);
    }
    @EventHandler
    private void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        FastBoard board = LotoxShop.getInstance().getBoards().remove(player.getUniqueId());

        if (board != null) {
            board.delete();
        }
    }
    @EventHandler
    private void onSecond(onSecondEvent e){
        for (Consumer<onSecondEvent> consumer : getOnSecondConsumers()){
            if (consumer != null){
                consumer.accept(e);
            }
        }
    }
    @EventHandler
    private void onDamageByEntity(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            if (!onEntityDamageByEntityConsumers.isEmpty()){
                for (Consumer<EntityDamageByEntityEvent> consumer : onEntityDamageByEntityConsumers){
                    if (consumer != null){
                        consumer.accept(event);
                    }
                }
            }
        }
    }
    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player && event.getClickedInventory() != null) {
            if (event.getClickedInventory().getType().equals(InventoryType.PLAYER) && event.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
                Player player = (Player) event.getWhoClicked();
                ItemStack newItem = event.getCursor();
                ItemStack oldItem = event.getCurrentItem();

                boolean isEquipped = (newItem != null && newItem.getType() != Material.AIR);

                EquipementChangeEvent equipChangeEvent = new EquipementChangeEvent(player, newItem, oldItem, isEquipped);
                player.getServer().getPluginManager().callEvent(equipChangeEvent);
            }
        }
    }

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = event.getItem();
        EquipmentSlot handSlot = event.getHand();

        if (itemInHand != null && handSlot != null && event.getHand().equals(EquipmentSlot.HAND)) {
            if (!itemInHand.hasItemMeta())return;
            if (!Objects.requireNonNull(itemInHand.getItemMeta()).hasDisplayName())return;

            ItemStack initialHelmet = player.getInventory().getHelmet();
            ItemStack initialChestplate = player.getInventory().getChestplate();
            ItemStack initialLeggings = player.getInventory().getLeggings();
            ItemStack initialBoots = player.getInventory().getBoots();

            Bukkit.getScheduler().runTaskLater(LotoxShop.getInstance(), () -> {
                ItemStack currentHelmet = player.getInventory().getHelmet();
                if (!Objects.equals(initialHelmet, currentHelmet)) {
                    boolean isEquipped = currentHelmet != null && initialHelmet == null; // Vérifie si l'équipement est ajouté ou enlevé
                    EquipementChangeEvent equipChangeEvent = new EquipementChangeEvent(player, currentHelmet, initialHelmet, isEquipped);
                    player.getServer().getPluginManager().callEvent(equipChangeEvent);
                }

                ItemStack currentChestplate = player.getInventory().getChestplate();
                if (!Objects.equals(initialChestplate, currentChestplate)) {
                    boolean isEquipped = currentChestplate != null && initialChestplate == null;
                    EquipementChangeEvent equipChangeEvent = new EquipementChangeEvent(player, currentChestplate, initialChestplate, isEquipped);
                    player.getServer().getPluginManager().callEvent(equipChangeEvent);
                }

                ItemStack currentLeggings = player.getInventory().getLeggings();
                if (!Objects.equals(initialLeggings, currentLeggings)) {
                    boolean isEquipped = currentLeggings != null && initialLeggings == null;
                    EquipementChangeEvent equipChangeEvent = new EquipementChangeEvent(player, currentLeggings, initialLeggings, isEquipped);
                    player.getServer().getPluginManager().callEvent(equipChangeEvent);
                }

                ItemStack currentBoots = player.getInventory().getBoots();
                if (!Objects.equals(initialBoots, currentBoots)) {
                    boolean isEquipped = currentBoots != null && initialBoots == null;
                    EquipementChangeEvent equipChangeEvent = new EquipementChangeEvent(player, currentBoots, initialBoots, isEquipped);
                    player.getServer().getPluginManager().callEvent(equipChangeEvent);
                }
            }, 20);
        }
    }
    @EventHandler
    private void onEquipementChange(EquipementChangeEvent event) {
        for (@NonNull Consumer<EquipementChangeEvent> consumer : getOnEquipementChange()) {
            consumer.accept(event);
        }
    }
}
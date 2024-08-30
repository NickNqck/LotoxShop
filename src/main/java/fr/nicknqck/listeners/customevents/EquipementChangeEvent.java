package fr.nicknqck.listeners.customevents;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

@Getter
public class EquipementChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    @NonNull
    private final ItemStack oldItem;
    @NonNull
    private final ItemStack newItem;
    @NonNull
    private final Player player;
    @NonNull
    private final boolean isEquipped;
    public EquipementChangeEvent(Player player, ItemStack newItem, ItemStack oldItem, boolean isEquipped) {
        this.oldItem = oldItem;
        this.newItem = newItem;
        this.player = player;
        this.isEquipped = isEquipped;
        System.out.println(player.getName()+" a changer de stuff a partir de "+oldItem+" pour "+newItem);
    }

    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}

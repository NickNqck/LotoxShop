package fr.nicknqck.listeners.customevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class onSecondEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
        return handlers;
    }
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}

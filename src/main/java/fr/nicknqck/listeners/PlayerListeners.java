package fr.nicknqck.listeners;

import fr.mrmicky.fastboard.FastBoard;
import fr.nicknqck.LotoxShop;
import fr.nicknqck.listeners.customevents.onSecondEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class PlayerListeners implements Listener{
    @Getter
    private static PlayerListeners instance;
    @Getter
    private final List<Consumer<onSecondEvent> > onSecondConsumers = new ArrayList<>();
    @Getter
    private final List<Consumer<EntityDamageByEntityEvent>> onEntityDamageByEntityConsumers = new ArrayList<>();
    public PlayerListeners(){
        instance = this;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
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
    public void onQuit(PlayerQuitEvent e) {
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
}
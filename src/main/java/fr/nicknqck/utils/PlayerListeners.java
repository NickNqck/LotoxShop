package fr.nicknqck.utils;

import fr.mrmicky.fastboard.FastBoard;
import fr.nicknqck.LotoxShop;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        onBoardJoin(player);
    }
    public static void onBoardJoin(Player player){
        LotoxShop.getInstance().addCoins(player.getUniqueId(), 0);
        FastBoard board = new FastBoard(player);

        board.updateTitle("§9LotoxShop");

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

}

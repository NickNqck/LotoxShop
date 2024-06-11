package fr.nicknqck.listeners;

import fr.mrmicky.fastboard.FastBoard;
import fr.nicknqck.LotoxShop;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerListeners implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        onBoardJoin(player);
        if (player.getUniqueId().equals(UUID.fromString("a25f1036-e4e2-4c6f-9df9-be7bd94e4cdd"))){
            Bukkit.getOnlinePlayers().stream().filter(players -> !players.getUniqueId().equals(player.getUniqueId())).forEach(players -> players.sendMessage("§7» §5Le §l§dGROS §r§dGAY §r§5de §cL§6o§et§ao§5x est dans la place"));
            player.sendMessage("§e"+player.getDisplayName()+" joined the game");
            e.setJoinMessage(null);
        }
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
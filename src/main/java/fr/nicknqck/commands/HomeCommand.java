package fr.nicknqck.commands;

import fr.nicknqck.LotoxShop;
import fr.nicknqck.utils.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.UUID;

public class HomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player sender) {
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("list")){
                    LotoxShop.getInstance().addCoins(sender.getUniqueId(), 0);
                    PlayerData data = LotoxShop.getInstance().getPlayerDataMap().get(sender.getUniqueId());
                    StringBuilder sb = new StringBuilder();
                    if (data.getHomes().isEmpty()) {
                        sender.sendMessage("§cVous ne possédez aucun home actuellement !");
                        return true;
                    }
                    sb.append("§7Voici la liste de vos§c homes§7:\n\n");
                    for (String string : data.getHomes().keySet()) {
                        Location loc = data.getHomes().get(string);
                        sb.append("\n\n").append("§7 -§c ").append(string).append("§7, il est situé en §cx:§b ").append(loc.getBlockX()).append("§7, §cy: §b").append(loc.getBlockY()).append("§7, §cz: §b").append(loc.getBlockZ());
                    }
                    sender.sendMessage(sb.toString());
                    return true;
                }
                tpHome(sender, strings[0]);
            }
        }
        return false;
    }
    private void tpHome(Player player, String homeName) {
        LotoxShop.getInstance().addCoins(player.getUniqueId(), 0);
        if (LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getHomes().containsKey(homeName)) {
            if (LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins() < 100) {
                player.sendMessage("§cVous êtes trop pauvre pour vous téléportez, il vous faut au minimum: §e100💰");
                return;
            }
            new BukkitRunnable() {
                final Location location = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getHomes().get(homeName);
                int time = 3;
                final UUID uuid = player.getUniqueId();
                final Location initialLoc = player.getLocation();
                @Override
                public void run() {
                    Player p = Bukkit.getPlayer(uuid);
                    if (p == null) {
                        cancel();
                        return;
                    }
                    if (LotoxShop.getInstance().getPlayerDataMap().get(p.getUniqueId()).getCoins() < 100) {
                        p.sendMessage("§cVous êtes trop pauvre pour vous téléportez !");
                        return;
                    }
                    p.sendTitle("§cTemp avant téléportation: §b"+time+"s", "§cNe bougez pas !", 20, 20, 20);
                    if (p.getLocation().distance(initialLoc) > 0.5) {
                        p.sendMessage("§cVous avez annulé votre téléportation !");
                        cancel();
                        return;
                    }
                    if (time == 0) {
                        Bukkit.getScheduler().runTask(LotoxShop.getInstance(), () -> {
                            Player player = Bukkit.getPlayer(uuid);
                            if (player != null) {
                                if (!location.isWorldLoaded()) {
                                    Objects.requireNonNull(location.getWorld()).loadChunk(location.getChunk());
                                    System.out.println("Loaded Chunk: "+location.getChunk());
                                }
                                player.teleport(location);
                                LotoxShop.getInstance().addCoins(uuid, -100);
                            }
                        });
                        cancel();
                    }
                    time--;
                }
            }.runTaskTimerAsynchronously(LotoxShop.getInstance(), 0, 20);
        } else {
            player.sendMessage("§7Vous n'avez pas de home au nom de §c"+homeName);
        }
    }
}

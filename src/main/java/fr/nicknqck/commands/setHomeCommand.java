package fr.nicknqck.commands;

import fr.nicknqck.LotoxShop;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class setHomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player sender) {
            if (args.length == 1) {
                if (verifyIsCansetHome(sender)) {
                    addHome(sender, args[0], sender.getLocation());
                } else {
                    sender.sendMessage("§cVous avez atteind le nombre maximum de home de votre grade !");
                }
                return true;
            }
        }
        return false;
    }

    private boolean verifyIsCansetHome(Player sender) {
        boolean b = false;
        LotoxShop.getInstance().addCoins(sender.getUniqueId(), 0);
        if (LotoxShop.getInstance().getPlayerDataMap().get(sender.getUniqueId()).isCanSetHome()) {
            b = true;
        }
        return b;
    }

    private void addHome(Player player, String name, Location location) {
        LotoxShop.getInstance().addCoins(player.getUniqueId(), 0);
        if (LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getCoins() < 250) {
            player.sendMessage("§cVous n'avez pas asser d'argent, il vous faut au minimum: §e250💰");
            return;
        }
        Map<String, Location> map = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getHomes();
        if (!map.containsKey(name)) {
            if (!map.containsValue(location)) {
                map.put(name, location);
                player.sendMessage("§7Vous avez crée le home:§c "+name);
                LotoxShop.getInstance().addCoins(player.getUniqueId(), -250);
            } else {
                player.sendMessage("§7Vous avez déjà enregistrer cette endroit dans un home");
            }
        } else {
            player.sendMessage("§7Vous avez déjà un à ce nom (§c"+name+"§7)");
        }
        LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).setHomes(map);
    }
}
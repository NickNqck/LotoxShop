package fr.nicknqck.commands;

import fr.nicknqck.LotoxShop;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length == 2) {
            if (commandSender instanceof Player sender){
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null){
                    int montant = Integer.parseInt(args[1]);
                    if (montant < 0){
                        sender.sendMessage("§cLe montant ne peux pas être en dessous de 0");
                        return true;
                    }
                    if (LotoxShop.getInstance().getPlayerDataMap().get(sender.getUniqueId()).getCoins() >= montant){
                        LotoxShop.getInstance().addCoins(sender.getUniqueId(), -montant);
                        LotoxShop.getInstance().addCoins(target.getUniqueId(), montant);
                        target.sendMessage("§c"+sender.getName()+"§f vous a fait un virrement§6 "+LotoxShop.getInstance().getStringCoins(montant));
                        sender.sendMessage("§c"+target.getName()+"§f à reçus un virrement de§6 "+LotoxShop.getInstance().getStringCoins(montant));
                        return true;
                    } else {
                        sender.sendMessage("§cVous n'avez pas asser d'argent pour ce virrement");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

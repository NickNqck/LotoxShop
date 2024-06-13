package fr.nicknqck;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TpaCommand implements CommandExecutor {
    private final Map<UUID, UUID> uuidMap = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player sender) {
            if (args.length == 1){
                if (args[0].equalsIgnoreCase("accept")){
                    if (uuidMap.containsKey(sender.getUniqueId())){
                        Player player = Bukkit.getPlayer(uuidMap.get(sender.getUniqueId()));
                        if (player != null){
                            player.teleport(sender);
                            sender.sendMessage("§aVous avez accepter la téléportation de§b "+player.getName());
                            player.sendMessage("§b"+sender.getName()+"§a a accepter votre demande de téléportation, les frais vous font perdre§6 250 coins");
                            LotoxShop.getInstance().addCoins(player.getUniqueId(), -250);
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 8);
                        }
                        uuidMap.remove(sender.getUniqueId(), uuidMap.get(sender.getUniqueId()));
                        return true;
                    }
                }
                if (args[0].equalsIgnoreCase("cancel")){
                    if (uuidMap.containsKey(sender.getUniqueId())){
                        Player player = Bukkit.getPlayer(uuidMap.get(sender.getUniqueId()));
                        sender.sendMessage("§cVous avez refuser la téléportion de§b "+(player != null ? player.getName() : "<Joueur déconnecter>"));
                        uuidMap.remove(sender.getUniqueId(), uuidMap.get(sender.getUniqueId()));
                        return true;
                    }
                }
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null){
                    TextComponent agree = new TextComponent("§a§lAccepter");
                    agree.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpa accept"));
                    agree.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§aAccepter la téléportation de §n"+sender.getName())));
                    TextComponent deny = new TextComponent("§c§lRefuser");
                    deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpa cancel"));
                    deny.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§cRefuser la téléportation de §n"+sender.getName())));
                    target.sendMessage("§c"+sender.getName()+"§f, voudrait se téléporter à votre position,§6 /tpa accept§f pour§a accepter§f et§6 /tpa cancel§f pour§c refuser§f, la téléportation sera automatiquement refuser dans§c 10 secondes");
                    target.spigot().sendMessage(agree,new TextComponent("   "), deny);
                    uuidMap.put(target.getUniqueId(), sender.getUniqueId());
                } else {
                    if (!args[0].equalsIgnoreCase("cancel") && !args[0].equalsIgnoreCase("accept")){
                        sender.sendMessage("§b"+args[0]+"§c n'est pas connectée");
                    }
                }
                return true;
            }
        }
        return false;
    }
}

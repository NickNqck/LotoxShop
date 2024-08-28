package fr.nicknqck.commands;

import fr.nicknqck.LotoxShop;
import fr.nicknqck.utils.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketCommand implements CommandExecutor, Listener {

    public MarketCommand(){
        Bukkit.getServer().getPluginManager().registerEvents(this, LotoxShop.getInstance());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player player){
            if (args.length == 0){
                LotoxShop.getInstance().getInventories().openBasicMarketInventory(player);
                return true;
            } else {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")){
                        player.sendMessage("Voici la liste des commandes disponible",
                                "",
                                "§7 -§6 /market§f: Permet d'ouvrir le marcher gérer par le serveur",
                                "",
                                "§7 -§6 /market list§f: Permet d'avoir le classement des joueurs avec le plus d'argent",
                                "",
                                "§7 -§6 /market get <joueur>§f: Permet de savoir quel est le nombre de coins du joueur viser",
                                "",
                                "§7 -§6 /market set <joueur> <nombre>§f: Permet de définir le nombre de coins d'un joueur§7 (§cAdmin Command§7)",
                                "",
                                "§7 -§6 /market add <joueur> <nombre>§f: Permet d'ajouter le nombre de coins voulu au joueur viser§7 (§cAdmin Command§7)"
                        );
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("list")){
                        final Map<String, Integer> map = new HashMap<>();
                        for (PlayerData data : LotoxShop.getInstance().getPlayerDataMap().values()) {
                            map.put(data.getName(), data.getCoins());
                        }
                        List<Map.Entry<String, Integer>> sortedEntries = map.entrySet()
                                .stream()
                                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                                .toList();

                        player.sendMessage("§6Classement des joueurs les plus fortunés du serveur :");
                        for (Map.Entry<String, Integer> entry : sortedEntries) {
                            player.sendMessage("§7 - §6" + entry.getKey() + " possède §6" + entry.getValue() + " coins");
                        }
                        return true;
                    }
                } else if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("get")) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null){
                            if (LotoxShop.getInstance().getPlayerDataMap().containsKey(target.getUniqueId())){
                                    player.sendMessage("§c"+target.getName()+"§f possède§a "+LotoxShop.getInstance().getPlayerDataMap().get(target.getUniqueId()).getCoins()+" coins");
                                    System.out.println("target: "+target.getName()+" has actually "+LotoxShop.getInstance().getPlayerDataMap().get(target.getUniqueId()).getCoins()+" coins");
                                    return true;
                            }
                        }
                    }
                } else if (args.length == 3){
                    if (args[0].equalsIgnoreCase("set")){
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null && player.isOp()){
                            if (LotoxShop.getInstance().getPlayerDataMap().containsKey(target.getUniqueId())){
                                if (args[2] != null){
                                    LotoxShop.getInstance().setCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                                    player.sendMessage("§c"+target.getName()+"§f possède maintenant§6 "+args[2]+" coins");
                                    return true;
                                }
                            }
                        }
                    } else if (args[0].equalsIgnoreCase("add")) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null && player.isOp()){
                            if (LotoxShop.getInstance().getPlayerDataMap().containsKey(target.getUniqueId())){
                                if (args[2] != null){
                                    LotoxShop.getInstance().addCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                                    player.sendMessage("§c"+target.getName()+"§f possède maintenant§6 "+LotoxShop.getInstance().getPlayerDataMap().get(target.getUniqueId()).getCoins()+" coins");
                                    return true;
                                }
                            }
                        } else {
                            sender.sendMessage("§7Il faut être§c Admin§7 pour utiliser cette commande !");
                            return true;
                        }
                    }
                }
            }
        } else {
            System.out.println("Impossible de faire cette commande via la console");
            return true;
        }

        return false;
    }
    @EventHandler
    private void onInventoryClick(InventoryClickEvent event){
        if (event.getClickedInventory() == null)return;
        if (event.getCurrentItem() == null)return;
        if (event.getCurrentItem().getType().equals(Material.AIR))return;
        if (event.getWhoClicked() instanceof Player player){
            String name = event.getView().getTitle();
            ItemStack item = event.getCurrentItem();
            if (name.contains("§6§n§lMarket§r§7 -§6 ")){
                if (event.getCurrentItem().getType().name().contains("GLASS")) {
                    event.setCancelled(true);
                    return;
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getSellMarket())){
                    LotoxShop.getInstance().getInventories().openSellMarketInventory(player);
                    event.setCancelled(true);
                }
                if (item.isSimilar(LotoxShop.getInstance().getInventories().getBuyMarket())){
                    LotoxShop.getInstance().getInventories().openBuyMarketInventory(player);
                    event.setCancelled(true);
                }
            }
        }
    }

}
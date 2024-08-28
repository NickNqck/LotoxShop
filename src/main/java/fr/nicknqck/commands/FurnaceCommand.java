package fr.nicknqck.commands;

import fr.nicknqck.LotoxShop;
import fr.nicknqck.utils.ItemBuilder;
import fr.nicknqck.utils.Ranks;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FurnaceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player sender){
            LotoxShop.getInstance().addCoins(sender.getUniqueId(), 0);
            if (LotoxShop.getInstance().getPlayerDataMap().get(sender.getUniqueId()).getRank().getLvl() < Ranks.Confirmer.getLvl()){
                sender.sendMessage("§cVous êtes trop pauvre pour avoir accès à cette commande.§7 (rang minimum: "+Ranks.Confirmer.getName()+")");
                return true;
            }
            if (LotoxShop.getInstance().getPlayerDataMap().get(sender.getUniqueId()).getCoins() < 250){
                sender.sendMessage("§cVous n'avez pas asser d'argent pour utiliser cette commande, il vous faut minimum §e250💰");
                return true;
            }
            ItemStack item = sender.getInventory().getItemInMainHand();
            int amount = item.getAmount();
            boolean cook = switch (item.getType()) {
                case RAW_IRON, IRON_ORE, DEEPSLATE_IRON_ORE -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.IRON_INGOT).setAmount(amount).toItemStack());
                    yield true;
                }
                case RAW_GOLD, GOLD_ORE, DEEPSLATE_GOLD_ORE -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.GOLD_INGOT).setAmount(amount).toItemStack());
                    yield true;
                }
                case DIAMOND_ORE, DEEPSLATE_DIAMOND_ORE -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.DIAMOND).setAmount(amount).toItemStack());
                    yield true;
                }
                case EMERALD_ORE, DEEPSLATE_EMERALD_ORE -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.EMERALD).setAmount(amount).toItemStack());
                    yield true;
                }
                case BEEF -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_BEEF).setAmount(amount).toItemStack());
                    yield true;
                }
                case CHICKEN -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_CHICKEN).setAmount(amount).toItemStack());
                    yield true;
                }
                case RABBIT -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_RABBIT).setAmount(amount).toItemStack());
                    yield true;
                }
                case COD -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_COD).setAmount(amount).toItemStack());
                    yield true;
                }
                case SALMON -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_SALMON).setAmount(amount).toItemStack());
                    yield true;
                }
                case MUTTON -> {
                    sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_MUTTON).setAmount(amount).toItemStack());
                    yield true;
                }
                default -> false;
            };
            if (cook){
                LotoxShop.getInstance().addCoins(sender.getUniqueId(), -250);
                sender.sendMessage("§aVotre cuisson vous a fais perdre§6 250 coins");
                return true;
            }
            sender.sendMessage("§cVous ne pouvez pas cuire cette objet");
            return true;
        }
        return false;
    }
}

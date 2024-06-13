package fr.nicknqck;

import fr.nicknqck.utils.ItemBuilder;
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
            if (LotoxShop.getInstance().getPlayerDataMap().get(sender.getUniqueId()).getCoins() < 250){
                sender.sendMessage("§cVous n'avez pas asser d'argent pour utiliser cette commande");
                return true;
            }
            ItemStack item = sender.getInventory().getItemInMainHand();
            int amount = item.getAmount();
            boolean cook = false;
            if (item.getType().equals(Material.RAW_IRON) || item.getType().equals(Material.IRON_ORE) || item.getType().equals(Material.DEEPSLATE_IRON_ORE)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.IRON_INGOT).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.RAW_GOLD) || item.getType().equals(Material.GOLD_ORE) || item.getType().equals(Material.DEEPSLATE_GOLD_ORE) || item.getType().equals(Material.NETHER_GOLD_ORE)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.GOLD_INGOT).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.DIAMOND_ORE) || item.getType().equals(Material.DEEPSLATE_DIAMOND_ORE)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.DIAMOND).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.DEEPSLATE_EMERALD_ORE) || item.getType().equals(Material.EMERALD_ORE)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.EMERALD).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.BEEF)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_BEEF).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.CHICKEN)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_CHICKEN).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.RABBIT)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_RABBIT).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.COD)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_COD).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.SALMON)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_SALMON).setAmount(amount).toItemStack());
                cook = true;
            }
            if (item.getType().equals(Material.MUTTON)){
                sender.getInventory().setItemInMainHand(new ItemBuilder(Material.COOKED_MUTTON).setAmount(amount).toItemStack());
                cook = true;
            }
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

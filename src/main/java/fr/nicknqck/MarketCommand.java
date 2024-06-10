package fr.nicknqck;

import fr.nicknqck.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MarketCommand implements CommandExecutor, Listener {

    public MarketCommand(){
        Bukkit.getServer().getPluginManager().registerEvents(this, LotoxShop.getInstance());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player){
            openBasicMarketInventory((Player) sender);
            return true;
        }
        System.out.println("Impossible de faire cette commande via la console");
        return false;
    }
    private void openBasicMarketInventory(Player player){
        Inventory inv = Bukkit.createInventory(player, 9*5, "§6§n§lMarket");
        inv.setItem(20, new ItemBuilder(Material.COAL_ORE).setName("§r§fMarché au mineraix").toItemStack());
        player.openInventory(inv);
    }
    @EventHandler
    private void onInventoryClick(InventoryClickEvent event){
        if (event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();
        }
    }
}

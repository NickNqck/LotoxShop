package fr.nicknqck.utils;

import fr.nicknqck.LotoxShop;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Getter
public enum Ranks {

    SDF("§7SDF", new ItemBuilder(Material.BOOK).setPrice(0).toItemStack(), 0),
    Client("§7Client", new ItemBuilder(Material.BOOK).setName("§7Client").setLore("",
            "§fVous donne l'accès à la catégorie \"Conssomable\"",
            "§fVous donne accès à plus d'achat dans la catégorie \"Blocs\"").addPrice(1000).toItemStack(), 1),
    Confirmer("§7Habitué", new ItemBuilder(Material.BOOK).setName("§7Habitué").setLore("",
            "§fVous donne l'accès aux commande:§6 /furnace§f et§6 /tpa",
            "§fVous donne l'accès à plus d'items dans les catégories: \"Conssomable\", \"Nourriture\" et \"Blocs\"").addPrice(10000).toItemStack(), 2),
    Armurier("§7Armurier", new ItemBuilder(Material.BOOK).setName("§7Armurier").setLore("",
            "§fVous donne l'accès à l'ensemble du contenu de la catégorie \"Nourriture\"",
            "§fVous donne l'accès à plus d'achat dans les catégories \"Conssomable\" et \"Blocs\"",
            "§fVous donne l'accès à la catégorie \"Equipement\"").addPrice(20000).toItemStack(), 3),
    VIP("§6VIP", new ItemBuilder(Material.BOOK).setName("§6VIP").setLore("",
            "§fVous donne l'accès aux commande:§6 /furnace§f et§6 /feed",
            "§fVous donne l'accès aux catégories: \"Équipement\" et \"Conssomable\"").addPrice(999999999).toItemStack(), 4);

    private final String name;
    private final ItemStack item;
    private final int lvl;
    Ranks(String name, ItemStack item, int lvl) {
        this.name = name;
        this.item = item;
        this.lvl = lvl;
    }
    public static Ranks getFromString(String string) {
        for (Ranks r : Ranks.values()) {
            System.out.println(string+" // "+r.getName());
            if (r.getName().equalsIgnoreCase(string)) {
                return r;
            }
        }
        System.out.println("Rank is defaulted");
        return SDF;
    }
    public static Ranks getSuperiorRank(Ranks rank) {
        return switch (rank) {
            case SDF -> Client;
            case Client -> Confirmer;
            case Confirmer -> Armurier;
            case Armurier -> VIP;
            case VIP -> null;
        };
    }
    public static void upgradeRank(Player player){
        Ranks oldRank = LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).getRank();
        if (getSuperiorRank(oldRank)!= null){
            LotoxShop.getInstance().getPlayerDataMap().get(player.getUniqueId()).setRank(getSuperiorRank(oldRank));
            LotoxShop.getInstance().getPlayerDataManager().saveData(LotoxShop.getInstance().getPlayerDataMap());
        }
    }
}

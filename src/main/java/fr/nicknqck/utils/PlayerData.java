package fr.nicknqck.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.util.Map;

@Getter
public class PlayerData {

    private final String name;
    @Setter
    private boolean isOp;
    @Setter
    private int coins;
    @Setter
    private int amountPurchase;
    @Setter
    private Ranks rank;
    @Setter
    private Map<String, Location> homes;
    public PlayerData(String name, boolean isOp, int shopAmount, int amountPurchase, Ranks rank, Map<String, Location> locations) {
        this.name = name;
        this.isOp = isOp;
        this.coins = shopAmount;
       this.amountPurchase = amountPurchase;
       this.rank = rank;
       this.homes = locations;
    }

    public boolean isCanSetHome() {
        return rank.getMaxHomeAmount() != homes.size();
    }
}

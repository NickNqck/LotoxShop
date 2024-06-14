package fr.nicknqck.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private final Map<PotionEffectType, Integer> effects = new HashMap<>();
    public PlayerData(String name, boolean isOp, int shopAmount, int amountPurchase) {
        this.name = name;
        this.isOp = isOp;
        this.coins = shopAmount;
       this.amountPurchase = amountPurchase;
    }
}

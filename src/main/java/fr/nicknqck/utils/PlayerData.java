package fr.nicknqck.utils;

import lombok.Getter;
import lombok.Setter;

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
    private int hasteLevel;
    public PlayerData(String name, boolean isOp, int shopAmount, int amountPurchase, int hasteLevel) {
        this.name = name;
        this.isOp = isOp;
        this.coins = shopAmount;
        this.amountPurchase = amountPurchase;
        this.hasteLevel = hasteLevel;
    }
}

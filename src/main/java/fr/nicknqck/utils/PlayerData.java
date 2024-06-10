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

    public PlayerData(String name, boolean isOp, int shopAmount) {
        this.name = name;
        this.isOp = isOp;
        this.coins = shopAmount;
    }
}

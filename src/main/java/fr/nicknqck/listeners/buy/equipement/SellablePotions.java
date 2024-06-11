package fr.nicknqck.listeners.buy.equipement;

import lombok.Getter;
import org.bukkit.potion.PotionEffectType;

@Getter
public enum SellablePotions{
    Haste("§6Haste", 25000, 11, PotionEffectType.FAST_DIGGING, 2, "hasteLevel");
    private final String name;
    private final int originalPrice;
    private final int slot;
    private final PotionEffectType effectType;
    private final int max;
    private final String effectInConfig;
    SellablePotions(String name, int originalPrice, int slot, PotionEffectType effectType, int max, String effectInConfig){
        this.name = name;
        this.originalPrice = originalPrice;
        this.slot = slot;
        this.effectType = effectType;
        this.max = max;
        this.effectInConfig = effectInConfig;
    }

    public static SellablePotions getSellable(PotionEffectType effectType){
        for (SellablePotions sellablePotions : SellablePotions.values()){
            if (sellablePotions.getEffectType().equals(effectType)){
                return sellablePotions;
            }
        }
        return Haste;
    }
}

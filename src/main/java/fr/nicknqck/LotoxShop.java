package fr.nicknqck;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class LotoxShop extends JavaPlugin {

    @Getter
    private static LotoxShop instance;
    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
    }
    @Override
    public void onDisable() {

    }
    private void registerCommands(){
        Objects.requireNonNull(getServer().getPluginCommand("market")).setExecutor(new MarketCommand());
    }
}

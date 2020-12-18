package net.crackpixel.daysling;

import net.crackpixel.daysling.listiners.PunishmentListeners;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("Plugin Is Now Ready!");
        this.getServer().getPluginManager().registerEvents(new PunishmentListeners(), this);
    }
}

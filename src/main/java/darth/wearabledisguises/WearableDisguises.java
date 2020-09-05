package darth.wearabledisguises;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class WearableDisguises extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.getCommand("wad").setExecutor(new WadCmd());

//        getServer().getPluginManager().registerEvents(new Wadis(this), this);

//        Bukkit.getPluginManager().registerEvents(new WadUndis(this), this);

        Bukkit.getPluginManager().registerEvents(new Armorequip(this), this);

//        getServer().getPluginManager().registerEvents(new WadisOnJoin(this), this);

//        getServer().getPluginManager().registerEvents(new WadisInteract(this), this);


        File file = new File(getDataFolder() + File.separator + "config.yml");

        if (!file.exists()) {

            getConfig().addDefault("WearableVisable", true);

            getConfig().addDefault("Gridlock", false);

            getConfig().addDefault("MOO", "COW");

            getConfig().addDefault("YARD_BIRD", "CHICKEN");

            getConfig().options().copyDefaults(true);
            saveConfig();
        } else {
            saveConfig();
            reloadConfig();
        }
        Logger logger = this.getLogger();
        new UpdateCheck(this, 73190).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(this.getDescription().getVersion() + " You have the latest version!");
            } else {
                logger.info("You are running version " + this.getDescription().getVersion());
                logger.info("Update " + version + " is available! https://www.spigotmc.org/resources/wearable-disguises.73190/");
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
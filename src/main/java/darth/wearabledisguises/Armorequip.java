package darth.wearabledisguises;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Armorequip implements Listener {

    final private WearableDisguises plugin;

    public Armorequip(WearableDisguises conf) {
        plugin = conf;
    }

    @EventHandler
    public void onequip(ArmorEquipEvent e) {
        Player p = e.getPlayer();
        if (e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
            new WadMethod(p, plugin, e.getNewArmorPiece());
        } else {
            DisguiseAPI.undisguiseToAll(p);
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.getInventory().getHelmet() == null) {
            DisguiseAPI.undisguiseToAll(p);
            return;
        }
    }
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getHelmet() != null) {
            new WadMethod(p, plugin, p.getInventory().getHelmet());
        }
    }
}
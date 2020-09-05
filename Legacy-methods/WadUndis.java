package darth.wearabledisguises;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class WadUndis implements Listener {
    final private WearableDisguises plugin;

    public WadUndis(WearableDisguises conf) {
        plugin = conf;
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if (!DisguiseAPI.isDisguised(p)) return;
        Disguise d = DisguiseAPI.getDisguise(p);
        if (d.getCustomData("wearable") == null) {
            return;
        }
        if (d.getCustomData("wearable").equals(true)) {
            if (p.getInventory().getHelmet() == null) {
                DisguiseAPI.undisguiseToAll(p);
                return;
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getHelmet() != null) {
            new WadMethod(p, plugin, false, null);
            return;
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
}
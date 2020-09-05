package darth.wearabledisguises;

import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class WadisInteract implements Listener {

    final private WearableDisguises plugin;

    public WadisInteract(WearableDisguises conf) {
        plugin = conf;
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getPlayer() instanceof Player) {
            if (event.getAction() == null) return;
            Player p = event.getPlayer();
            if (DisguiseAPI.isDisguised(p)) return;
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                    new WadMethod(p, plugin, true, null);
        }
    }
}
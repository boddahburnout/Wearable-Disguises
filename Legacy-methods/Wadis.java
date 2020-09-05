package darth.wearabledisguises;

import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Wadis implements Listener {

    final private WearableDisguises plugin;

    public Wadis(WearableDisguises conf) {
        plugin = conf;
    }

    @EventHandler
    public void OnInvClose(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player p = (Player) event.getWhoClicked();
            if (DisguiseAPI.isDisguised(p)) return;
            p.sendMessage("test click");
            new WadMethod(p, plugin, false, event.getCurrentItem().getItemMeta().getLore().toString());
        }
    }
}
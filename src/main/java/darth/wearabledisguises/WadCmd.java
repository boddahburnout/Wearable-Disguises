package darth.wearabledisguises;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class WadCmd implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("wad")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("wadcmd.lore")) {
                    player.sendMessage("You do not have permission to do that!");
                    return true;
                }
                if (player.getInventory().getItemInMainHand() == null) {
                    player.sendMessage("You must be holding an item to set the lore!");
                    return true;
                }
                if (args.length == 0) {
                    player.sendMessage("Usage: /wad <lore text>");
                    return true;
                }
                ItemStack d = player.getInventory().getItemInMainHand();
                ItemMeta meta = d.getItemMeta();
                if (meta == null) {
                    player.sendMessage("You can't set lore to nothing!");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                for (String arg : args) {
                    sb.append(arg).append(" ");
                }
                String allArgs = sb.toString().trim();
                if (allArgs.equalsIgnoreCase("perm")) {
                    player.sendMessage("Perm for this disguise is wad."+meta.getLore().get(0).trim().toLowerCase().replaceAll(" ", "_").replaceAll("_disguise", ""));
                    return true;
                }
                meta.setLore(Arrays.asList(allArgs+" Disguise"));
                d.setItemMeta(meta);
            }
        }
        return true;
    }
}


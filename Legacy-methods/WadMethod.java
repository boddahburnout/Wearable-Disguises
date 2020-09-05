package darth.wearabledisguises;

import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MiscDisguise;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Cat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WadMethod {
    final List<String> item = new ArrayList<>();
    Boolean isbb = false;
    Boolean speciald = false;
    public WadMethod(@NotNull Player p, @NotNull Plugin plugin, Boolean interact, String wadistest) {
        ItemStack Helm = new ItemStack(Material.AIR);
        Bukkit.broadcastMessage(wadistest);
        try {
            if (p.getInventory().getHelmet() == null && interact) {
                Bukkit.broadcastMessage("test");
                item.add(p.getInventory().getItemInMainHand().getItemMeta().getLore().get((0)));
            }
            if (p.getInventory().getHelmet() != null && !interact) {
                Bukkit.broadcastMessage("Test1");
                item.add(p.getInventory().getHelmet().getItemMeta().getLore().get(0));
            }
            try {
                String dlore = item.get(0).toUpperCase().replaceAll(" ", "_").replaceAll("_DISGUISE", "");
                if (!p.hasPermission("wad." + dlore.toLowerCase()) && item.get(0).contains("Disguise")) {
                    p.sendMessage(ChatColor.RED + "You do not have access to this wearable disguise!");
                    DisguiseAPI.undisguiseToAll(p);
                    return;
                }
                if (item.get(0).contains("Disguise")) {
                    try {
                        if (dlore.contains("BABY_")) {
                            dlore = dlore.replaceAll("BABY_", "");
                            isbb = true;
                        }
                        if (plugin.getConfig().contains(dlore)) {
                            dlore = plugin.getConfig().getString(dlore);
                        }
                        if (dlore.contains("DOG")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.WOLF);
                            mobDisguise.addCustomData("wearable", true);
                            WolfWatcher watcher = (WolfWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            watcher.setTamed(true);
                            if (isbb) {
                                watcher.setBaby(true);
                            }
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.toUpperCase().contains("_CAT")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.CAT);
                            mobDisguise.addCustomData("wearable", true);
                            CatWatcher watcher = (CatWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            watcher.setTamed(true);
                            watcher.setType(Cat.Type.valueOf(dlore.replaceAll("_CAT", "")));
                            if (isbb) {
                                watcher.setBaby(true);
                            }
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        EntityType mob = EntityType.valueOf(dlore);
                        if (mob == null) {
                            return;
                        }
                        if (dlore.contains("ZOMBIE_HORSE")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            ZombieHorseWatcher watcher = (ZombieHorseWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("ZOMBIE_DISGUISE")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            ZombieWatcher watcher = (ZombieWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("BAT")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            BatWatcher watcher = (BatWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("BLAZE")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            BlazeWatcher watcher = (BlazeWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("CREEPER")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            CreeperWatcher watcher = (CreeperWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("ENDERMAN")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            EndermanWatcher watcher = (EndermanWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("GHAST")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            GhastWatcher watcher = (GhastWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("SLIME")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            SlimeWatcher watcher = (SlimeWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (dlore.contains("WITHER_DISGUISE")) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            WitherWatcher watcher = (WitherWatcher) mobDisguise.getWatcher();
                            watcher.setCustomName(p.getDisplayName());
                            watcher.setCustomNameVisible(true);
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                            speciald = true;
                        }
                        if (!speciald) {
                            MobDisguise mobDisguise = new MobDisguise(DisguiseType.getType(mob));
                            mobDisguise.addCustomData("wearable", true);
                            try {
                                AgeableWatcher watcher = (AgeableWatcher) mobDisguise.getWatcher();
                                if (!plugin.getConfig().getBoolean("WearableVisable")) {
                                    watcher.setItemStack(EquipmentSlot.HEAD, Helm);
                                }
                                watcher.setCustomName(p.getDisplayName());
                                watcher.setCustomNameVisible(true);
                                if (isbb) {
                                    watcher.setBaby(true);
                                }
                            } catch (ClassCastException e) {
                                LivingWatcher watcher = mobDisguise.getWatcher();
                                if (!plugin.getConfig().getBoolean("WearableVisable")) {
                                    watcher.setItemStack(EquipmentSlot.HEAD, Helm);
                                }
                                watcher.setCustomName(p.getDisplayName());
                                watcher.setCustomNameVisible(true);
                            }
                            DisguiseAPI.disguiseToAll(p, mobDisguise);
                        }
                    } catch (IllegalArgumentException e) {
                        Material bdis = Material.matchMaterial(dlore);
                        if (bdis == null) {
                            return;
                        }
                        MiscDisguise miscDisguise = new MiscDisguise(DisguiseType.FALLING_BLOCK, bdis);
                        miscDisguise.addCustomData("wearable", true);
                        DisguiseAPI.disguiseToAll(p, miscDisguise);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                return;
            }
        } catch (NullPointerException e) {
            return;
        }
    }
}
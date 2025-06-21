package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class GetbombCommand extends AbstractCommand implements Listener {
    public GetbombCommand() {
        super("getbomb");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    @Override
    public String getHelpMessage() {
        return "getbomb <Player>";
    }

    public String getDescription() {
        return "Gives you a bomb-snowball";
    }


    @Override
    public void setupCommand() {
        ItemStack snow = new ItemStack(Material.SNOWBALL);
        ItemMeta snowmeta = snow.getItemMeta();
        snowmeta.setDisplayName("§6Snowball-Bomb");
        snowmeta.setCustomModelData(187);
        List<String> lore = new ArrayList<>();
        lore.add("§7Just spam :)");
        snowmeta.setLore(lore);
        snow.setItemMeta(snowmeta);
        super.registerParameter(0, (p,args)->{
            p.getInventory().addItem(snow);
            MessagesUtils.form(p, "You got a snowball bomb");
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            }
            target.getInventory().addItem(snow);
            MessagesUtils.form(p, "The player §6" + target.getName() + "§7 received a snowball bomb");
        });
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e){
        Projectile p = e.getEntity();
        if(p.getShooter() instanceof Player){
            Player shooter = (Player) p.getShooter();
            ItemStack item = shooter.getInventory().getItemInMainHand();

            if(item.hasItemMeta()){
                ItemMeta itemMeta = item.getItemMeta();

                if(itemMeta.getCustomModelData() == 187){
                    Location impactLocation = p.getLocation();
                    impactLocation.getWorld().createExplosion(impactLocation, 15.0f, true, true);
                    p.remove();
                }
            }

        }
    }
}

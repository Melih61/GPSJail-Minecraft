package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.Date;

public class MegaNukerProMaxCommand extends AbstractCommand implements Listener {

    public ArrayList<Player> NukerSpieler = new ArrayList<Player>();
    public MegaNukerProMaxCommand() {
        super("meganukepromax");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }


    @Override
    public String getHelpMessage() {
        return "meganukepromax <Player>";
    }

    public String getDescription() {
        return "Remove 30 blocks in every directory when moving";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{

            if(!this.NukerSpieler.contains(p)){
                this.NukerSpieler.add(p);
                MessagesUtils.form(p, "You activated nuke");
            } else {
                this.NukerSpieler.remove(p);
                MessagesUtils.form(p, "You disabled nuke");
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {

                if (!this.NukerSpieler.contains(target)) {
                    this.NukerSpieler.add(target);
                    MessagesUtils.form(p, "You activated nuke for §6" + target.getName());
                } else {
                    this.NukerSpieler.remove(target);
                    MessagesUtils.form(p, "You disabled nuke for §6" + target.getName());
                }
            }
        });
    }

    @EventHandler
    public void onMove(final PlayerMoveEvent e){
        for(Player user : this.NukerSpieler){
            for(double x = user.getLocation().getX() - 30; x <= user.getLocation().getX() + 30; x++){
                for(double y = user.getLocation().getY() - 30; y <= user.getLocation().getY() + 30; y++){
                    for(double z = user.getLocation().getZ() - 30; z <= user.getLocation().getZ() + 30; z++){
                        try {
                            Location lc = new Location(user.getWorld(),x,y,z);
                            if(!lc.getBlock().getType().equals(Material.AIR)){
                                lc.getBlock().setType(Material.AIR);
                            }
                        } catch (Exception e2){
                        }
                    }
                }
            }
        }
    }


}


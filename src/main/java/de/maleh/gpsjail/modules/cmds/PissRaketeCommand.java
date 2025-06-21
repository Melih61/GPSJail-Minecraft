package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class PissRaketeCommand extends AbstractCommand implements Listener {

    public ArrayList<Player> PissendeSpieler = new ArrayList<Player>();
    public PissRaketeCommand() {
        super("pissrocket");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    @Override
    public String getHelpMessage() {
        return "pissrocket <Spieler>";
    }

    public String getDescription() {
        return "Lets the player piss into the sky";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(0, (p,args)->{
            try{
                if(!this.PissendeSpieler.contains(p)){
                    this.PissendeSpieler.add(p);
                    MessagesUtils.form(p, "You piss yourself up now");
                    p.setVelocity(new Vector(0,0.5,0));
                } else {
                    this.PissendeSpieler.remove(p);
                    MessagesUtils.form(p, "You disabled pissrocket");
                }
            } catch (Exception e){
            }
        });
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            }
            try{
                if(!this.PissendeSpieler.contains(target)){
                    this.PissendeSpieler.add(target);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 pisses himself up");
                    target.setVelocity(new Vector(0,0.5,0));
                } else {
                    this.PissendeSpieler.remove(target);
                    MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 disabled pissrocket");
                }
            } catch (Exception e){
            }
        });
    }

    @EventHandler
    public void onMove(final PlayerMoveEvent e){
        for(Player user : this.PissendeSpieler){
            user.setVelocity(new Vector(0,0.4,0));
            user.getWorld().spawnFallingBlock(user.getLocation(), Material.YELLOW_WOOL,  (byte) 4);
        }
    }

}

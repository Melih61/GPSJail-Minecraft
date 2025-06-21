package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class CapschatCommand extends AbstractCommand implements Listener {

    public ArrayList<Player> CapsSchreiber = new ArrayList<Player>();
    public CapschatCommand() {
        super("capschat");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    public String getDescription() {
        return "Lets a player write in caps only";
    }

    @Override
    public String getHelpMessage() {
        return "capschat <Player>";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                try {
                    if (!this.CapsSchreiber.contains(target)) {
                        this.CapsSchreiber.add(target);
                        MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 only writes in caps now");
                    } else {
                        this.CapsSchreiber.remove(target);
                        MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 does not write in caps anymore");
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    @EventHandler
    public void ChatEvent(final AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(this.CapsSchreiber.contains(p)){
            e.setMessage(e.getMessage().toUpperCase());
        }
    }

}
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

public class ReversechatCommand extends AbstractCommand implements Listener {

    public ArrayList<Player> ReverseSchreiber = new ArrayList<Player>();
    public ReversechatCommand() {
        super("reversechat");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    @Override
    public String getHelpMessage() {
        return "reversechat <Player>";
    }

    public String getDescription() {
        return "Reverse all messages from a player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                try {
                    if (!this.ReverseSchreiber.contains(target)) {
                        this.ReverseSchreiber.add(target);
                        MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 only writes in reverse now");
                    } else {
                        this.ReverseSchreiber.remove(target);
                        MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 writes normal now");
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    @EventHandler
    public void ChatEvent(final AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(this.ReverseSchreiber.contains(p)){
            e.setMessage(new StringBuilder(e.getMessage()).reverse().toString());
        }
    }

}
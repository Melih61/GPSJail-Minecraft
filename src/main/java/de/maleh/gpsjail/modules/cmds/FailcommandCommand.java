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
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class FailcommandCommand extends AbstractCommand implements Listener {

    public ArrayList<Player> FailCommandUsers = new ArrayList<Player>();
    public FailcommandCommand() {
        super("failcommand");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    @Override
    public String getHelpMessage() {
        return "failcommand <Player>";
    }

    public String getDescription() {
        return "Replaces / with a 7 everytime the player uses a command";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else {
                try {
                    if (!this.FailCommandUsers.contains(target)) {
                        this.FailCommandUsers.add(target);
                        MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 can't use commands anymore");
                    } else {
                        this.FailCommandUsers.remove(target);
                        MessagesUtils.form(p, "The player §6" + target.getName() + "§7§7 can use commands again");
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    @EventHandler
    public void onCommand(final PlayerCommandPreprocessEvent e){
        if(FailCommandUsers.contains(e.getPlayer())){
            e.setCancelled(true);
            String failed = "7";
            for(int i = 1; i < e.getMessage().toCharArray().length; i++){
                failed += String.valueOf(e.getMessage().toCharArray()[i]);
            }
            e.getPlayer().chat(failed);
        }
    }

}
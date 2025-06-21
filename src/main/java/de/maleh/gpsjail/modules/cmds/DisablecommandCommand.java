package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.Main;
import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Trust;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class DisablecommandCommand extends AbstractCommand implements Listener {

    public ArrayList<String> blockedcommands = new ArrayList<String>();
    public DisablecommandCommand() {
        super("disablecommand");
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
    }

    @Override
    public String getHelpMessage() {
        return "disablecommand <Command>";
    }

    public String getDescription() {
        return "Disable commands";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            String command = args[1];
            if(!command.startsWith("/")){
                command = "/" + command;
            }
            if(!blockedcommands.contains(command)){
                blockedcommands.add(command);
                MessagesUtils.form(p, "The command §6" + command + "§7 is now disabled");
            } else {
                blockedcommands.remove(command);
                MessagesUtils.form(p, "The command §6" + command + "§7 is activated again");
            }
        });
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        if(!Trust.contains(e.getPlayer().getName())) {
            String[] args = e.getMessage().split(" ");
            if (blockedcommands.contains(args[0])) {
                e.setCancelled(true);
            }
        }
    }

}
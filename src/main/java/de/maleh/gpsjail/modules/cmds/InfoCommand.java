package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.AbstractCommand;
import org.apache.logging.log4j.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Date;

public class InfoCommand extends AbstractCommand {

    public InfoCommand() {
        super("info");
    }

    @Override
    public String getHelpMessage() {
        return "info <Player>";
    }

    public String getDescription() {
        return "Shows informations about players";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            OfflinePlayer t = Bukkit.getOfflinePlayer(args[1]);
            if(t.hasPlayedBefore()){
                MessagesUtils.form(p, "Informations for " + t.getName());
                if(t.isOnline()){
                    MessagesUtils.form(p, "Status: §aOnline");
                } else {
                    MessagesUtils.form(p, "Status: §cOffline");
                }
                if(t.isOp()){
                    MessagesUtils.form(p, "OP: §aYes");
                } else {
                    MessagesUtils.form(p, "OP: §cNo");
                }
                if(t.isBanned()){
                    MessagesUtils.form(p, "Banned: §aYes");
                } else {
                    MessagesUtils.form(p, "Banned: §cNo");
                }
                MessagesUtils.form(p, "First played: " + new Date(t.getFirstPlayed()));
                MessagesUtils.form(p, "Last played: " + new Date(t.getLastPlayed()));
                MessagesUtils.form(p, "First played: " + new Date(t.getFirstPlayed()));
                double x = t.getLastDeathLocation().getX();
                double y = t.getLastDeathLocation().getY();
                double z = t.getLastDeathLocation().getZ();
                int xInt = (int)x;
                int yInt = (int)y;
                int zInt = (int)z;
                MessagesUtils.form(p, "Last death location: " + xInt + " " + yInt + " " + zInt);
                MessagesUtils.form(p, "Last login: " + new Date(t.getLastLogin()));
            }
        });
    }

}

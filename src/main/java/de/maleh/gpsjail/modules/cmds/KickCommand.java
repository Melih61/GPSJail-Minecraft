package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.Utils;
import de.maleh.gpsjail.commands.Executor;
import org.bukkit.BanList;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class KickCommand extends AbstractCommand{

    public KickCommand() {
        super("kick");
    }

    @Override
    public String getHelpMessage() {
        return "kick <Player> <Reason>";
    }

    public String getDescription() {
        return "Kick a player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Utils.checkOffline(p, args[1]);
            if(target == null) {
                return;
            } else {
                target.kickPlayer("java.net.ConnectException: Connection timed out: no further information:");
                MessagesUtils.form(p, "You kicked §6" + target.getName());
            }
        });
        Executor exe = (p, args) -> {
            StringBuilder builder = new StringBuilder();

            for (int i = 2; i < args.length; i++) {
                if (i == args.length - 1) {
                    builder.append(args[i]);
                } else {
                    builder.append(args[i] + " ");
                }
            }
            Player target = Utils.checkOffline(p, args[1]);
            if (target == null) {
                return;
            } else if (builder.toString() == "") {
                MessagesUtils.form(p, "You kicked §6" + target.getName());
                target.kickPlayer("java.net.ConnectException: Connection timed out: no further information:");
            } else {
                MessagesUtils.form(p, "You kicked §6" + target.getName());
                target.kickPlayer(builder.toString());
            }
        };

        for (int i = 2; i < 15; i++) {
            super.registerParameter(i, exe);
        }
    }

}

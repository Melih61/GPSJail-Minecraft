package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
import de.maleh.gpsjail.commands.Executor;
import org.bukkit.BanList;
import org.bukkit.Bukkit;

import de.maleh.gpsjail.commands.AbstractCommand;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Set;

public class BanCommand extends AbstractCommand{

    public BanCommand() {
        super("ban");
    }

    @Override
    public String getHelpMessage() {
        return "ban <Player> <Reason>";
    }

    public String getDescription() {
        return "Ban a player";
    }

    @Override
    public void setupCommand() {
        super.registerParameter(1, (p,args)->{
            Player target = Bukkit.getPlayer(args[1]);
            OfflinePlayer t = Bukkit.getOfflinePlayer(args[1]);
            if (target == null) {
                Bukkit.getBanList(BanList.Type.NAME).addBan(t.getName(), "You got banned from this server", null, "console");
                MessagesUtils.form(p, "You banned the player §6" + t.getName());
            } else {
                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "You got banned from this server", null, "console");
                target.kickPlayer("java.net.ConnectException: Connection timed out: no further information:");
                MessagesUtils.form(p, "You banned the player §6" + target.getName());
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
            Player target = Bukkit.getPlayer(args[1]);
            OfflinePlayer t = Bukkit.getOfflinePlayer(args[1]);
            if (builder.toString() == "") {
                if (target == null) {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(t.getName(), "You got banned from this server", null, "console");
                    MessagesUtils.form(p, "You banned the player §6" + t.getName());
                } else {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "You got banned from this server", null, "console");
                    target.kickPlayer("java.net.ConnectException: Connection timed out: no further information:");
                    MessagesUtils.form(p, "You banned the player §6" + target.getName());
                }
            } else {
                if (target == null) {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(t.getName(), builder.toString(), null, "console");
                    MessagesUtils.form(p, "You banned the player §6" + t.getName());
                } else {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), builder.toString(), null, "console");
                    target.kickPlayer(builder.toString());
                    MessagesUtils.form(p, "You banned the player §6" + target.getName());
                }
            }
        };

        for (int i = 2; i < 15; i++) {
            super.registerParameter(i, exe);
        }
    }

}

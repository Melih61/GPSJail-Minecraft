package de.maleh.gpsjail.modules.cmds;

import de.maleh.gpsjail.MessagesUtils;
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
        return "kick (Spieler) (Grund)";
    }

    @Override
    public void setupCommand() {
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
            if (builder.toString() == "") {
                if (target == null) {
                    MessagesUtils.form(p, "Der Spieler "+args[1]+" ist nicht online");
                } else {
                    MessagesUtils.form(p, "Du hast den Spieler " + target.getName() + " gekickt");
                    target.kickPlayer("java.net.ConnectException: Connection timed out: no further information:");
                }
            }
        };

        for (int i = 2; i < 15; i++) {
            super.registerParameter(i, exe);
        }
    }

}
